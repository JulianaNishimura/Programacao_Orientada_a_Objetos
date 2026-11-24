package org.example.practiceExams.exam04.customer;

import java.util.Objects;

public class Customer {
    private final String plate;
    private String phone;
    private final VehicleType type;

    public Customer(String plate, VehicleType type, String phone) {
        this.plate = plate;
        this.type = type;
        this.phone = phone;
    }

    public String getPlate() {
        return plate;
    }

    public String getPhone() {
        return phone;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(plate, customer.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate, phone, type);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "plate='" + plate + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }
}
