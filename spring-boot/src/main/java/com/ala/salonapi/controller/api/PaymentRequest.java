package com.ala.salonapi.controller.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Data
@Builder
public class PaymentRequest {

	@Email
	@NotNull(message = "Email is required")
	private final String email;

	@NotBlank
	@Size(min = 3, message = "First Name should be at least 3 characters")
	private final String firstName;

	@NotBlank
	@Size(min = 3, message = "Last Name should be at least 3 characters")
	private final String lastName;

	@NotBlank
	@Size(min = 10, message = "Phone should be at least 10 characters")
	private final String phoneNumber;

	@NotNull(message = "Salon Service Detail Id is required")
	private final Integer selectedSalonServiceDetailId;

	@NotNull(message = "Slot Id is required")
	private final Integer slotId;
}
