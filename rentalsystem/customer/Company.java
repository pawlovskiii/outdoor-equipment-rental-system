package rentalsystem.customer;


public class Company extends Customer {

    private final int nip;

    public Company(String name, int nip) {
        super(name, DiscountLevel.COMPANY);
        this.nip = nip;
    }

}
