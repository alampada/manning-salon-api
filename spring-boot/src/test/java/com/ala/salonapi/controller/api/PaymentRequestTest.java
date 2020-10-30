package com.ala.salonapi.controller.api;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentRequestTest {

	private Validator validator;

	@BeforeEach
	private void setup() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void shouldNotAcceptNotValidEmail() {
		PaymentRequest paymentRequest = PaymentRequest.builder()
				.email("aaaa")
				.firstName("fooo")
				.lastName("baaar")
				.phoneNumber("1234567890")
				.slotId(1)
				.selectedSalonServiceDetailId(1)
				.build();

		Set<ConstraintViolation<PaymentRequest>> validationResult =
				validator.validate(paymentRequest);

		ConstraintViolation<PaymentRequest> violation = validationResult.iterator().next();

		assertThat(validationResult.size()).isEqualTo(1);
	}

	@Test
	public void shouldAcceptValidRequest() {
		PaymentRequest paymentRequest = PaymentRequest.builder()
				.email("someone@someone.com")
				.firstName("fooo")
				.lastName("baaar")
				.phoneNumber("1234567890")
				.slotId(1)
				.selectedSalonServiceDetailId(1)
				.build();

		Set<ConstraintViolation<PaymentRequest>> validationResult =
				validator.validate(paymentRequest);

		assertThat(validationResult).isEmpty();
	}

}