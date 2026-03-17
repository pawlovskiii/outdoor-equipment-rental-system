package rentalsystem.customer;

import java.math.BigDecimal;

enum DiscountLevel {

    INDIVIDUAL(new BigDecimal("0.9")),
    COMPANY(new BigDecimal("0.8")),
    SCHOOL(new BigDecimal("0.7"));

    private final BigDecimal discount;

    DiscountLevel(BigDecimal discount) {
        this.discount = discount;
    }

    BigDecimal getDiscount() {
        return discount;
    }
}
