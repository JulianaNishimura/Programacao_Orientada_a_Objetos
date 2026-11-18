package org.example.class06.genericTypes;

public class Computer implements Reportable {
    private String brand;
    private int ramInGb;
    private double price;

    public Computer(String brand, int ramInGb, double price) {
        this.brand = brand;
        this.ramInGb = ramInGb;
        this.price = price;
    }

    @Override
    public String[] reportContent() {
        return new String[]{brand, ramInGb + "GB", String.valueOf(price)};
    }
}
