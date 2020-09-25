package com.ala.salonapi.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.Slot;
import com.ala.salonapi.domain.repository.SalonServiceDetailRepository;
import com.ala.salonapi.domain.repository.SlotRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
@AllArgsConstructor
@CrossOrigin("*")
public class SalonController {

	private final SalonServiceDetailRepository salonServiceDetailRepository;

	private final SlotRepository slotRepository;

	@GetMapping(value = "/retrieveAvailableSalonServices", produces = "application/json")
	@ApiOperation("RetrieveAvailableSalonServicesAPI")
	public Iterable<SalonServiceDetail> retrieveAvailableSalonServices() {
		return salonServiceDetailRepository.findAll();
	}

	@GetMapping(value = "/retrieveAvailableSlots/{salonServiceId}/{formattedDate}", produces = "application/json")
	public Iterable<Slot> retrieveAvailableSlots(
			@ApiParam(required = true, format = "yyyy-MM-dd",example = "2020-08-30", value = "Date in yyyy-MM-dd format") @PathVariable  String formattedDate,
			@ApiParam(required = true, example = "42") @PathVariable  int salonServiceId) {
		final SalonServiceDetail salonServiceDetail = salonServiceDetailRepository.findById(salonServiceId)
				.orElseThrow(RuntimeException::new);
		final LocalDateTime start = LocalDate.parse(formattedDate).atStartOfDay();
		final LocalDateTime end = LocalDateTime.of(LocalDate.parse(formattedDate), LocalTime.MAX);
		return slotRepository.findSlotsByAvailableServicesAndStatusAndSlotForBetween(salonServiceDetail, Slot.SlotStatus.AVAILABLE,
				start, end);
	}

}
