package com.ala.salonapi.controller.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalonDetails {
	String address;
	String city;
	String name;
	String phone;
	String state;
	String zipcode;
}
