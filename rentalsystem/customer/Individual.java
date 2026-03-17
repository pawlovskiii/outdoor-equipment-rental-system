package rentalsystem.customer;


public class Individual extends Customer {

    private final String lastName;

    public Individual(String firstName, String lastName) {
        super(firstName, DiscountLevel.INDIVIDUAL);
        this.lastName = lastName;
    }

}
