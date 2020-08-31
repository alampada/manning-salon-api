package com.ala.salonapi.controller;

import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.repository.SalonServiceDetailRepository;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
@AllArgsConstructor
@CrossOrigin("*")
public class SalonController {

	SalonServiceDetailRepository salonServiceDetailRepository;

	@GetMapping(value = "/retrieveAvailableSalonServices", produces = "application/json")
	@ApiOperation("RetrieveAvailableSalonServicesAPI")
	public Iterable<SalonServiceDetail> retrieveAvailableSalonServices() {
		return salonServiceDetailRepository.findAll();
	}
}
