package rentalsystem.equipment;

import java.math.BigDecimal;

public enum EquipmentType {

    BASIC(new BigDecimal("50")),
    INTERMEDIATE(new BigDecimal("100")),
    ADVANCED(new BigDecimal("150"));

    private final BigDecimal rentalPricePerDay;

    EquipmentType(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }
}
