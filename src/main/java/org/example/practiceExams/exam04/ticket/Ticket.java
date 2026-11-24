package org.example.practiceExams.exam04.ticket;

import org.example.practiceExams.exam04.customer.Customer;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private final UUID id;
    private final Customer customer;
    private final LocalDateTime entry;
    private LocalDateTime exit;
    private Double fee;

    public Ticket(Customer customer) {
        this.customer = customer;
        this.entry = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public Ticket(UUID id, Customer customer, LocalDateTime entry) {
        this.id = id;
        this.customer = customer;
        this.entry = entry;
    }

    //TODO Crie também o método parkingDuration(), para calcular e retornar a duração do veículo no estacionamento.
    public void exit(){
        LocalDateTime exit = LocalDateTime.now();
        if(exit.isAfter(this.entry)){
            this.exit = exit;
        }
    }

    public void parkingDuration(){

    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getEntry() {
        return entry;
    }

    public LocalDateTime getExit() {
        return exit;
    }

    public Double getFee() {
        return fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customer=" + customer +
                ", entry=" + entry +
                ", exit=" + exit +
                ", fee=" + fee +
                '}';
    }
}
