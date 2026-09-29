package org.example.class05.exercises.ex02;

import java.time.LocalDate;

public final class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobtitle, LocalDate dateOfEmployment, double monthlySalary) {
        super(id, name, jobtitle, dateOfEmployment);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double salary() {
        return monthlySalary;
    }
}
