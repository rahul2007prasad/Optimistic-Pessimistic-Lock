package com.rahul.lock.controller;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.function.FailableRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.lock.entity.BusDetails;
import com.rahul.lock.repo.BusRepo;
import com.rahul.lock.service.BookingService;


@RestController
@RequestMapping("/lock")
public class LockingController {

	@Autowired
	public BookingService bookingService;
	
	
	@Autowired
	private BusRepo busRepo;
	
	@GetMapping("/bookTicket")
	public void bookeTicket() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(run(bookingService::bookTicket));
		executor.execute(run(bookingService::bookTicket2));
		
		executor.shutdown();
	}

	private Runnable run(FailableRunnable<Exception> runnable) {
		
		return ()->{
			try {
				runnable.run();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		};
	}
	
	@GetMapping("/addBus")
	public void addBus(@RequestParam String num , @RequestParam int capacity) {
		BusDetails busDetails = new BusDetails();
		busDetails.setCapacity(capacity);
		busDetails.setNum(num);
		busDetails.setDeparttime(LocalDateTime.now());
		busRepo.save(busDetails);
		
	}
	
}
