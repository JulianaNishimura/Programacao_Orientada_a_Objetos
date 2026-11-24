package org.example.practiceExams.exam04.persistence;

import org.example.practiceExams.exam04.ticket.EntryTicketDto;
import org.example.practiceExams.exam04.ticket.ExitTicketDto;
import org.example.practiceExams.exam04.ticket.TicketDao;

import java.util.Optional;

public class EntryTicketDaoImpl implements TicketDao {
    @Override
    public void save(EntryTicketDto EntryDto) {

    }

    @Override
    public Optional<EntryTicketDto> findOpenTicket(String id) {
        return Optional.empty();
    }

    @Override
    public void updateExit(ExitTicketDto ExitDto) {

    }
}
