package org.example.class06.interfacesAndPolimorfism;

public class Main {
    public static void main(String[] args) {
        WarehouseWorker someWarehouse = new WarehouseWorker(); // less flexible
        ShippingService warehouse = new WarehouseWorker(); // more flexible

        System.out.println(warehouse.calculateDeliveryTime()); // 3
        System.out.println(warehouse.generateShippingLabel()); // Warehouse standard stamp
        // Interface static method. No need of concrete instances.
        System.out.println(ShippingService.generateShipmentLog());
    }

}
