package rentalsystem.customer;


public class School extends Customer {

    private final int numberOfStudents;

    public School(String name, int numberOfStudents) {
        super(name, DiscountLevel.SCHOOL);
        this.numberOfStudents = numberOfStudents;
    }
}
