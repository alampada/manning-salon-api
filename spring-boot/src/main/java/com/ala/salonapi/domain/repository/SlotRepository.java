package com.ala.salonapi.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.Slot;

import org.springframework.data.repository.CrudRepository;

public interface SlotRepository extends CrudRepository<Slot, Integer> {

	List<Slot> findSlotsByAvailableServicesAndStatusAndSlotForBetween(SalonServiceDetail salonServiceDetail, Slot.SlotStatus status,
			LocalDateTime start, LocalDateTime end);

	Slot findSlotByIdAndAvailableServicesAndStatus(int id, SalonServiceDetail salonServiceDetail, Slot.SlotStatus status);

}

