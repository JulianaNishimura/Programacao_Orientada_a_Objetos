package org.example.class06.interfacesAndPolimorfism;

public class WarehouseWorker implements ShippingService {

    @Override
    public int calculateDeliveryTime() {
        return 3;
    }

    @Override
    public String generateShippingLabel() {
        return "Warehouse standard stamp";
    }
}