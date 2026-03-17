package rentalsystem.rental;

import rentalsystem.customer.Customer;
import rentalsystem.equipment.Equipment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Rental {

    private final Customer customer;
    private final Equipment equipment;
    private final LocalDate startDate;
    private LocalDate endDate;
    private final RentalType rentalType;

    Rental(Customer customer, Equipment equipment, LocalDate startDate, LocalDate endDate, RentalType rentalType) {
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
        this.equipment = Objects.requireNonNull(equipment, "Equipment cannot be null");
        this.startDate = Objects.requireNonNull(startDate, "From cannot be null");
        this.endDate = Objects.requireNonNull(endDate, "To cannot be null");
        this.rentalType = Objects.requireNonNull(rentalType, "Rental type cannot be null");

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("From date cannot be after to date");
        }
        customer.addRental(this);
        equipment.addRental(this);
    }

    void makeEarlyReturn(LocalDate returnDate) {
        if (!returnDate.isBefore(startDate) && !returnDate.isAfter(endDate)) {
            this.endDate = returnDate;
        } else {
            throw new IllegalArgumentException("Return date cannot be before rental start or after rental ends");
        }
    }

    BigDecimal calculateEquipmentRental() {
        long rentalDays = ChronoUnit.DAYS.between(startDate, endDate);

        BigDecimal dailyCost = equipment.getPricePerDay();
        BigDecimal discount = customer.getDiscount();
        BigDecimal totalCost = dailyCost.multiply(BigDecimal.valueOf(rentalDays));

        return totalCost.multiply(discount);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    Customer getCustomer() {
        return customer;
    }

    Equipment getEquipment() {
        return equipment;
    }

    RentalType getRentalType() {
        return rentalType;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "customer=" + customer +
                ", equipment=" + equipment +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rentalType=" + rentalType +
                '}';
    }
}
