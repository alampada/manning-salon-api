package com.ala.salonapi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.ala.salonapi.controller.api.ConfirmationResponse;
import com.ala.salonapi.controller.api.PaymentRequest;
import com.ala.salonapi.domain.Payment;
import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.Slot;
import com.ala.salonapi.domain.Ticket;
import com.ala.salonapi.domain.repository.PaymentRepository;
import com.ala.salonapi.domain.repository.SalonServiceDetailRepository;
import com.ala.salonapi.domain.repository.SlotRepository;
import com.ala.salonapi.domain.repository.TicketRepository;
import com.ala.salonapi.exception.SalonException;import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

	private final SlotRepository slotRepository;

	private final SalonServiceDetailRepository salonServiceDetailRepository;

	private final PaymentRepository paymentRepository;

	private final TicketRepository ticketRepository;

	private final SalonDetailsService salonDetailsService;

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

	public ConfirmationResponse confirmPayment(long id) {
		Payment payment = paymentRepository.findById(id).orElseThrow(
				() -> new SalonException("Invalid Payment"));
		if (payment.getStatus() == Payment.PaymentStatus.SUCCESS) {
			throw  new SalonException("Payment already confirmed");
		}
		if (!stripePaymentService.isPaymentSuccessful(payment.getIntentId())) {
			throw  new SalonException("Payment not successful");
		}
		Ticket ticket = Ticket.builder()
				.payment(payment)
				.ticketStatus(Ticket.Status.BOOKED)
				.build();

		payment.setStatus(Payment.PaymentStatus.SUCCESS);

		payment.getSlot().setStatus(Slot.SlotStatus.CONFIRMED);

		payment.getSlot().setConfirmedAt(LocalDateTime.now());

		payment.getSlot().setSelectedService(payment.getSelectedService());

		ticketRepository.save(ticket);

		return ConfirmationResponse.builder()
				.ticket(ticket)
				.salonDetails(salonDetailsService.getSalonDetails())
				.build();
	}

	public Ticket getTicket(long id) {
		return ticketRepository.findById(id)
				.orElseThrow(() -> new SalonException("Ticket not valid"));
	}
}
