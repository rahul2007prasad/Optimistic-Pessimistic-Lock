package com.rahul.lock.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="ticket_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastname;
	
	
	private String gender;
	@Version
	private Long version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bus_id")
	private BusDetails busDetails;
	
	
}
