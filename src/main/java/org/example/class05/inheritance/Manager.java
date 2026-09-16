package org.example.class05.inheritance;

import java.time.LocalDate;

public class Manager extends Employee{
    private String department;

    public Manager(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment, String department) {
        super(id, name, jobTitle, salary, dateOfEmployment);
        this.department = department;
    }

    public double calculateProfitSharing(double profit){
        return(getYearsOfService()/5)*profit*0.0001;
    }
}
