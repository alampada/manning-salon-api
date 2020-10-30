package com.ala.salonapi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.ala.salonapi.controller.api.PaymentRequest;
import com.ala.salonapi.domain.Payment;
import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.Slot;
import com.ala.salonapi.domain.repository.PaymentRepository;
import com.ala.salonapi.domain.repository.SalonServiceDetailRepository;
import com.ala.salonapi.domain.repository.SlotRepository;
import com.ala.salonapi.exception.SalonException;import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

	private final SlotRepository slotRepository;

	private final SalonServiceDetailRepository salonServiceDetailRepository;

	private final PaymentRepository paymentRepository;

	private final StripePaymentService stripePaymentService;

	public Payment createPayment(PaymentRequest paymentRequest) {

		SalonServiceDetail salonServiceDetail = salonServiceDetailRepository.findById(paymentRequest.getSelectedSalonServiceDetailId())
				.orElseThrow(() -> new SalonException("Invalid SalonServiceDetail id"));

		Slot slot = Optional.ofNullable(
				slotRepository
						.findSlotByIdAndAvailableServicesAndStatus(paymentRequest.getSlotId(), salonServiceDetail, Slot.SlotStatus.AVAILABLE))
				.orElseThrow(() -> new SalonException("Slot invalid or unavailable"));

		PaymentIntentDetails paymentIntentDetails = stripePaymentService.createIntent(salonServiceDetail.getPrice());

		Payment payment = Payment.builder()
				.selectedService(salonServiceDetail)
				.slot(slot)
				.amount(paymentIntentDetails.getAmmount())
				.phoneNumber(paymentRequest.getPhoneNumber())
				.intentId(paymentIntentDetails.getIntentId())
				.lastName(paymentRequest.getLastName())
				.firstName(paymentRequest.getFirstName())
				.email(paymentRequest.getEmail())
				.clientSecret(paymentIntentDetails.getSecretId())
				.build();

		paymentRepository.save(payment);

		slot.setLockedAt(LocalDateTime.now());
		slot.setStatus(Slot.SlotStatus.LOCKED);

		return payment;
	}
}
