package com.example.optionals.car;

public class Optionals {

    public static String getCarInsuranceNameNotSafe(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public static String getCarInsuranceNameNested(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    public static String getCarInsuranceNameMultipleExitPoints(Person person) {
        if (person == null) return "Unknown";
        Car car = person.getCar();
        if (car == null) return "Unknown";
        Insurance insurance = car.getInsurance();
        if (insurance == null) return "Unknown";
        return insurance.getName();
    }

    public static String getCarInsuranceName(Person person) {
        return "TODO!"; // TODO 6.1.1
    }

}
