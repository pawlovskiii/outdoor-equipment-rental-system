package rentalsystem.equipment;

import rentalsystem.rental.Rental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Equipment {

    private final String name;
    private final double weight;
    private EquipmentCondition equipmentCondition;
    private final EquipmentType equipmentType;
    private final List<Rental> rentalList = new ArrayList<>();

    Equipment(String name, double weight, EquipmentCondition equipmentCondition, EquipmentType equipmentType) {
        this.name = name;
        this.weight = weight;
        this.equipmentCondition = equipmentCondition;
        this.equipmentType = equipmentType;
    }

    void setEquipmentCondition(EquipmentCondition equipmentCondition) {
        this.equipmentCondition = equipmentCondition;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public boolean isAvailableGivenDay(LocalDate date) {
        return rentalList.stream()
                .noneMatch(rental -> !date.isBefore(rental.getStartDate()) && !date.isAfter(rental.getEndDate()));
    }

    public boolean isAvailableWithinPeriod(LocalDate startDate, LocalDate endDate) {
        return rentalList.stream()
                .noneMatch(rental -> rental.getStartDate().isBefore(endDate) && rental.getEndDate().isAfter(startDate));
    }

    public BigDecimal getPricePerDay() {
        return equipmentType.getRentalPricePerDay();
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public String getName() {
        return name;
    }

    public EquipmentCondition getEquipmentCondition() {
        return equipmentCondition;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", equipmentCondition=" + equipmentCondition +
                ", equipmentType=" + equipmentType +
                '}';
    }
}
