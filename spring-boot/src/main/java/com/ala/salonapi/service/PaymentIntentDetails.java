package com.ala.salonapi.service;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentIntentDetails {
	String intentId;
	String secretId;
	long ammount;
}
