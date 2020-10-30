package com.ala.salonapi.service;

import com.stripe.model.PaymentIntent;
import com.stripe.net.RequestOptions;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service to integrate with Stripe.
 */
@Service
public class StripePaymentService {

	private final String stripeKey;

	public StripePaymentService(
			@Value("${stripe.key}") String stripeKey) {
		this.stripeKey = stripeKey;
	}

	@SneakyThrows
	public PaymentIntentDetails createIntent(long amount) {
		PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
				.setAmount(amount)
				.setCurrency("USD")
				.build();
		RequestOptions requestOptions = RequestOptions.builder()
				.setApiKey(stripeKey)
				.build();
		PaymentIntent paymentIntent = PaymentIntent.create(createParams, requestOptions);
		return new PaymentIntentDetails(paymentIntent.getId(), paymentIntent.getClientSecret(), paymentIntent
				.getAmount());
	}
}
