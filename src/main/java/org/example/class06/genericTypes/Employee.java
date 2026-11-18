package org.example.class06.genericTypes;

public class Employee implements Reportable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String[] reportContent() {
        return new String[]{name, String.valueOf(salary)};
    }
}
