# Outdoor Equipment Rental System

## Table of contents

- [General info](#general-info)
- [Features](#features)
- [Project Structure](#project-structure)
- [Setup](#setup)
  - [Run the project](#run-the-project)
- [Example Output](#example-output)

## General info

Application simulating an outdoor equipment rental service. The system supports managing different types of equipment (bikes, tents, backpacks), handling various customer categories with individual discount levels, and processing rentals with availability checking, early returns, and report generation.

Built as a learning project to practice core Java concepts.

## Features

- **Equipment management** — add equipment to the system, track its condition (functional/damaged)
- **Customer types** — individuals, companies, and schools, each with a different discount level
- **Rental processing** — rent or reserve equipment with date-range validation and availability checking
- **Availability checking** — verify if equipment is available on a specific day or within a date range
- **Early returns** — return equipment before the scheduled end date, recalculating the rental period
- **Report generation** — per-equipment summary: rental count by customer, date ranges, and total costs

## Project Structure

```
rentalsystem/
├── Main.java                        — demo scenario with sample data
├── customer/
│   ├── Customer.java                — abstract base for all customer types
│   ├── Individual.java              — private person (first name, last name)
│   ├── Company.java                 — company (name, NIP)
│   ├── School.java                  — school (name, number of students)
│   └── DiscountLevel.java           — enum: INDIVIDUAL / COMPANY / SCHOOL (with discount multiplier)
├── equipment/
│   ├── Equipment.java               — abstract base for all equipment types
│   ├── Bike.java
│   ├── Tent.java
│   ├── Backpack.java
│   ├── EquipmentType.java           — enum: BASIC / INTERMEDIATE / ADVANCED (with price per day)
│   └── EquipmentCondition.java      — enum: FUNCTIONAL / DAMAGED
└── rental/
    ├── RentalSystem.java            — core service: processes orders, returns, and reports
    ├── Rental.java                  — links a customer, equipment, and date range; calculates cost
    └── RentalType.java              — enum: RENTED / RESERVED
```

## Setup

To clone and run this application, you'll need [Git](https://git-scm.com) and [JDK 17+](https://www.oracle.com/java/technologies/downloads/) installed on your computer.

```bash
# Clone this repository
$ git clone https://github.com/pawlovskiii/outdoor-equipment-rental-system

# Go into the repository
$ cd outdoor-equipment-rental-system
```

### Run the project

```bash
# Compile all source files
$ javac rentalsystem/**/*.java rentalsystem/Main.java

# Run the application
$ java rentalsystem.Main
```

## Example Output

```
Check 'The North Face' availability for 2026-01-02:
true

Equipment: 'The North Face' was rented/reserved: 
1x by British High School
1x by PWC
Equipment: 'The North Face' was reserved from 2026-02-01 to 2026-02-20 by British High School cost 665.0
Equipment: 'The North Face' was rented from 2026-03-01 to 2026-03-11 by PWC cost 400.0

Equipment: 'Coleman Kobuk' was rented/reserved: 
2x by Tom
1x by British High School
1x by PWC
Equipment: 'Coleman Kobuk' was rented from 2026-01-01 to 2026-01-11 by PWC cost 800.0
Equipment: 'Coleman Kobuk' was reserved from 2026-02-01 to 2026-02-20 by Tom cost 1710.0
Equipment: 'Coleman Kobuk' was rented from 2026-03-01 to 2026-03-11 by Tom cost 900.0
Equipment: 'Coleman Kobuk' was rented from 2026-04-01 to 2026-04-03 by British High School cost 140.0

Equipment: 'Cube' was rented/reserved: 
1x by Tom
1x by PWC
Equipment: 'Cube' was rented from 2026-01-01 to 2026-01-05 by Tom cost 540.0
Equipment: 'Cube' was rented from 2026-04-01 to 2026-04-11 by PWC cost 1200.0
```
