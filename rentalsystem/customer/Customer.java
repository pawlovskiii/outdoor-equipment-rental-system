package rentalsystem.customer;

import rentalsystem.rental.Rental;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    private final String name;
    private final DiscountLevel discountLevel;
    private final List<Rental> rentalList = new ArrayList<>();

    Customer(String name, DiscountLevel discountLevel) {
        this.name = name;
        this.discountLevel = discountLevel;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public BigDecimal getDiscount() {
        return discountLevel.getDiscount();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
