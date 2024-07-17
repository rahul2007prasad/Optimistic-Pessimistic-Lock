package com.rahul.lock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.lock.entity.Ticket;

public interface TicketInfoRepo extends JpaRepository<Ticket, Long>{

}
