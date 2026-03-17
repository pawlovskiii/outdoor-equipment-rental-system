package rentalsystem.rental;

import rentalsystem.customer.Customer;
import rentalsystem.equipment.Equipment;
import rentalsystem.equipment.EquipmentCondition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RentalSystem {

    private final List<Equipment> equipmentList = new ArrayList<>();

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    public void returnEquipment(Rental rental, LocalDate date) {
        if (equipmentList.contains(rental.getEquipment())) {
            rental.makeEarlyReturn(date);
        } else {
            throw new NoSuchElementException("Given equipment does not exist in the system");
        }
    }

    public Rental processEquipmentOrder(Customer customer, Equipment equipment, LocalDate startDate, LocalDate endDate, RentalType rentalType) {
        if (!equipmentList.contains(equipment)) {
            throw new NoSuchElementException("Rental system does not have given equipment");
        }
        if (equipment.getEquipmentCondition() == EquipmentCondition.DAMAGED) {
            throw new IllegalStateException("Given equipment is not available, because is damaged");
        }
        if (!equipment.isAvailableWithinPeriod(startDate, endDate)) {
            throw new IllegalStateException("Given equipment is not available within given period");
        }
        return new Rental(customer, equipment, startDate, endDate, rentalType);
    }

    public String generateReport(Equipment equipment) {

        StringBuilder report = new StringBuilder("\nEquipment: '" + equipment.getName() + "'" + " was rented/reserved: ");
        for (Map.Entry<Customer, Integer> entry : countRentalsByCustomer(equipment).entrySet()) {
            report.append("\n").append(entry.getValue()).append("x by ").append(entry.getKey().getName());
        }
        report.append("\n");
        for (Rental rental : equipment.getRentalList()) {
            var rentalInfo = "Equipment: '%s' was %s from %s to %s by %s cost %s%n".formatted( // REMEMBER
                    rental.getEquipment().getName(),
                    rental.getRentalType().toString().toLowerCase(),
                    rental.getStartDate(),
                    rental.getEndDate(),
                    rental.getCustomer().getName(),
                    rental.calculateEquipmentRental()
            );
            report.append(rentalInfo);
        }
        return report.toString();
    }

    Map<Customer, Integer> countRentalsByCustomer(Equipment equipment) {
        return equipment.getRentalList().stream()
                .collect(Collectors.toMap(
                        Rental::getCustomer,
                        rental -> 1,
                        Integer::sum
                ));
    }
}
