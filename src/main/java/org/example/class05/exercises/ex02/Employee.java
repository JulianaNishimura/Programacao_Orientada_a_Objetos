package org.example.class05.exercises.ex02;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits FullTimeEmployee, PerhourEmployee {
    private String id, name, jobTitle;
    private LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    public abstract double salary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Employee {id='%s',name='%s',jobTitle='%s',dateOfEmployment=%s}", id, name, jobTitle, dateOfEmployment);
    }
}
