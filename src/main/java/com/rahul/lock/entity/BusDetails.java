package com.rahul.lock.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="bus_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDetails {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime departtime;
	
	private String num;
	
	private Integer capacity;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy ="busDetails")
	private Set<Ticket> tickets;
	
	public void addTicket(Ticket ticket) {
		ticket.setBusDetails(this);
		getTickets().add(ticket);
	}
	
	
}
