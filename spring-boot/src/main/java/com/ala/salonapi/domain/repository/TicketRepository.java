package com.ala.salonapi.domain.repository;

import com.ala.salonapi.domain.Ticket;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
