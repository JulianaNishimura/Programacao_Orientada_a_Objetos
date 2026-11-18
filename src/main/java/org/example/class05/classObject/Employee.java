package org.example.class05.classObject;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(dateOfEmployment, employee.dateOfEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobTitle, salary, dateOfEmployment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    //há também o método getclass que nao pode ser sobrecritos, entre outros.
}