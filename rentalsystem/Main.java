package rentalsystem;

import rentalsystem.customer.Company;
import rentalsystem.customer.Individual;
import rentalsystem.customer.School;
import rentalsystem.equipment.Backpack;
import rentalsystem.equipment.Bike;
import rentalsystem.equipment.EquipmentCondition;
import rentalsystem.equipment.EquipmentType;
import rentalsystem.equipment.Tent;
import rentalsystem.rental.Rental;
import rentalsystem.rental.RentalSystem;
import rentalsystem.rental.RentalType;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {

        RentalSystem outdoorRentalSystem = new RentalSystem();

        Backpack backpack = new Backpack("The North Face", 500, EquipmentCondition.FUNCTIONAL, EquipmentType.BASIC);
        Tent tent = new Tent("Coleman Kobuk", 6000, EquipmentCondition.FUNCTIONAL, EquipmentType.INTERMEDIATE);
        Bike bike = new Bike("Cube", 9000, EquipmentCondition.FUNCTIONAL, EquipmentType.ADVANCED);

        outdoorRentalSystem.addEquipment(backpack);
        outdoorRentalSystem.addEquipment(tent);
        outdoorRentalSystem.addEquipment(bike);

        Individual tom = new Individual("Tom", "Doe");
        School britishHigh = new School("British High School", 100);
        Company pwc = new Company("PWC", 1234567891);

        LocalDate startDate1 = LocalDate.of(2026, 1, 1);
        LocalDate endDate1 = LocalDate.of(2026, 1, 11);

        LocalDate startDate2 = LocalDate.of(2026, 2, 1);
        LocalDate endDate2 = LocalDate.of(2026, 2, 20);

        LocalDate startDate3 = LocalDate.of(2026, 3, 1);
        LocalDate endDate3 = LocalDate.of(2026, 3, 11);

        LocalDate startDate4 = LocalDate.of(2026, 4, 1);
        LocalDate endDate4 = LocalDate.of(2026, 4, 11);


        Rental rental1 = outdoorRentalSystem.processEquipmentOrder(tom, bike, startDate1, endDate1, RentalType.RENTED);
        Rental rental2 = outdoorRentalSystem.processEquipmentOrder(pwc, tent, startDate1, endDate1, RentalType.RENTED);

        Rental rental3 = outdoorRentalSystem.processEquipmentOrder(britishHigh, backpack, startDate2, endDate2, RentalType.RESERVED);
        Rental rental4 = outdoorRentalSystem.processEquipmentOrder(tom, tent, startDate2, endDate2, RentalType.RESERVED);

        Rental rental5 = outdoorRentalSystem.processEquipmentOrder(pwc, backpack, startDate3, endDate3, RentalType.RENTED);
        Rental rental6 = outdoorRentalSystem.processEquipmentOrder(tom, tent, startDate3, endDate3, RentalType.RENTED);

        Rental rental7 = outdoorRentalSystem.processEquipmentOrder(pwc, bike, startDate4, endDate4, RentalType.RENTED);
        Rental rental8 = outdoorRentalSystem.processEquipmentOrder(britishHigh, tent, startDate4, endDate4, RentalType.RENTED);


        outdoorRentalSystem.returnEquipment(rental1, LocalDate.of(2026, 1, 5));
        outdoorRentalSystem.returnEquipment(rental8, LocalDate.of(2026, 4, 3));
        System.out.printf("Check '%s' availability for %s:%n%s%n",
                backpack.getName(), LocalDate.of(2026, 1, 2),
                backpack.isAvailableGivenDay(LocalDate.of(2026, 1, 2)));

        System.out.println(outdoorRentalSystem.generateReport(backpack));
        System.out.println(outdoorRentalSystem.generateReport(tent));
        System.out.println(outdoorRentalSystem.generateReport(bike));
    }
}
