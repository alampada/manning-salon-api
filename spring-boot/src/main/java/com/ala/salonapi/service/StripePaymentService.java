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
				.setAmount(amount * 100)
				.setCurrency("USD")
				.build();
		PaymentIntent paymentIntent = PaymentIntent.create(createParams, buildRequestOptions());
		return new PaymentIntentDetails(paymentIntent.getId(), paymentIntent.getClientSecret(), paymentIntent
				.getAmount());
	}

	@SneakyThrows
	public boolean isPaymentSuccessful(String intentId) {
		return "succeeded".equals(PaymentIntent.retrieve(intentId,
				buildRequestOptions()).getStatus());
	}

	private RequestOptions buildRequestOptions() {
		return RequestOptions.builder()
				.setApiKey(stripeKey)
				.build();
	}
}
