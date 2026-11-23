package org.example.practiceExams.exam04.ticket;

import org.example.practiceExams.exam04.customer.CustomerDto;

import java.util.Optional;

public interface TicketDao {
    void save(EntryTicketDto EntryDto);
    Optional<EntryTicketDto> findOpenTicket(String id);
    void updateExit(ExitTicketDto ExitDto);
}
