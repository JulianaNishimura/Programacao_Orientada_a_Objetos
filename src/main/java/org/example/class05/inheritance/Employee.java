package org.example.class05.inheritance;

import java.time.LocalDate;

public class Employee {
    private String id, name, jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    public Employee(){}

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService(){
        LocalDate today = LocalDate.now();
        double years = dateOfEmployment.until(today).getYears();
        return years;
    }

    public double calculateBonus(){
        double bonusPercentage = 0.05;
        if(getYearsOfService() >= 5){
            bonusPercentage += 0.1;
        }
        return salary * bonusPercentage;
    }
}