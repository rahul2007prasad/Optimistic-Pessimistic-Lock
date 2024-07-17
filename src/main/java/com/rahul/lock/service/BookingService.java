package com.rahul.lock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.lock.entity.BusDetails;
import com.rahul.lock.entity.Ticket;
import com.rahul.lock.repo.BusRepo;
import com.rahul.lock.repo.TicketInfoRepo;
import com.rahul.lock.service.exception.SeatNotAvailable;

@Service
public class BookingService {

	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private TicketInfoRepo ticketInfoRepo;
	
	public void saveTicket(String firstName , String lastName ,String gender, BusDetails busDetails) throws SeatNotAvailable {
		if(busDetails.getCapacity() <= busDetails.getTickets().size()) {
			throw new SeatNotAvailable();
		}
		
		Ticket ticket = new Ticket();
		ticket.setFirstName("Rahul");
		ticket.setLastname("prasad");
		ticket.setGender("male");
		ticket.setGender("male");
		
		busDetails.addTicket(ticket);
		ticketInfoRepo.save(ticket);
	}
	
	
	public void bookTicket() throws SeatNotAvailable, InterruptedException {
		Optional<BusDetails> busOptional = busRepo.findById(1L);
	
			if(busOptional.isPresent()) {
				saveTicket("KP", "Ku","female",busOptional .get());
			}
			
			Thread.sleep(1000);
	}
	public void bookTicket2() throws SeatNotAvailable, InterruptedException {
		Optional<BusDetails> busOptional = busRepo.findById(1L);
	
			if(busOptional.isPresent()) {
				saveTicket("RP", "Ku","male",busOptional .get());
			}
			
			Thread.sleep(1000);
	}
	
	
}
