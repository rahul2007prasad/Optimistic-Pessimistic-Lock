package com.rahul.lock.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.rahul.lock.entity.BusDetails;

import jakarta.persistence.LockModeType;

public interface BusRepo extends JpaRepository<BusDetails, Long> {
	
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	//@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<BusDetails>  findWithLockingById(Long id);
}
