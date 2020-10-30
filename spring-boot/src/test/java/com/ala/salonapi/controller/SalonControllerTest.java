package com.ala.salonapi.controller;

import com.ala.salonapi.domain.repository.SalonServiceDetailRepository;
import com.ala.salonapi.domain.repository.SlotRepository;
import com.ala.salonapi.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class SalonControllerTest {

	@MockBean
	private SalonServiceDetailRepository salonServiceDetailRepository;

	@MockBean
	private SlotRepository slotRepository;

	@MockBean
	private BookingService bookingService;

	@Autowired
	SalonController salonController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldInitiatePayment() throws Exception {
		String requestBody = "{\n"
				+ "    \"email\" : \"foo@\",\n"
				+ "    \"firstName\": \"foo\",\n"
				+ "    \"lastName\" : \"bar\",\n"
				+ "    \"phoneNumber\" : \"1234567890\",\n"
				+ "    \"selectedSalonServiceDetailId\": 1,\n"
				+ "    \"slotId\" : 1119\n"
				+ "}";

		String requestResponse = "{\n"
				+ "    \"type\": \"BAD_REQUEST\",\n"
				+ "    \"message\": \"Invalid Request\",\n"
				+ "    \"errors\": [\n"
				+ "        {\n"
				+ "            \"field\": \"email\",\n"
				+ "            \"rejectedValue\": \"foo@\",\n"
				+ "            \"message\": \"must be a well-formed email address\"\n"
				+ "        }\n"
				+ "    ]\n"
				+ "}";

		mockMvc.perform(
				post("/api/services/api/payments/initiate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isBadRequest())
				.andExpect(content().json(requestResponse));
	}

}