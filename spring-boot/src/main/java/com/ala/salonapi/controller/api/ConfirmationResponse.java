package com.ala.salonapi.controller.api;

import com.ala.salonapi.domain.Ticket;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfirmationResponse {

	SalonDetails salonDetails;

	Ticket ticket;
}
