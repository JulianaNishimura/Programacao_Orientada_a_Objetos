package org.example.class05.exercises.ex02;

import java.time.LocalDate;

public final class PerhourEmployee extends Employee{
    private double hourlyRate;
    private int workedHour;

    public PerhourEmployee(String id, String name, String jobtitle, LocalDate dateOfEmployment, double hourlyRate, int workedHour) {
        super(id, name, jobtitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate * workedHour;
    }
}
