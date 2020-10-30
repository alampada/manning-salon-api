package com.ala.salonapi.service;

import com.ala.salonapi.configuration.Salon;
import com.ala.salonapi.controller.api.SalonDetails;

import org.springframework.stereotype.Service;

@Service
public class SalonDetailsService {

	private final Salon salon;

	private final SalonDetails salonDetails;

	public SalonDetailsService(Salon salon) {
		this.salon = salon;
		this.salonDetails = SalonDetails.builder()
				.address(salon.getAddress())
				.city(salon.getCity())
				.name(salon.getName())
				.phone(salon.getPhone())
				.state(salon.getState())
				.zipcode(salon.getZipcode())
				.build();
	}

	SalonDetails getSalonDetails() {
		return salonDetails;
	}
}
