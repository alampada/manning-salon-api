package com.ala.salonapi.domain.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.ala.salonapi.domain.Payment;
import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.Slot;
import org.assertj.core.data.TemporalOffset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class PaymentRepositoryTest {

	@Autowired
	private PaymentRepository testObject;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testCreatePayment() {
		SalonServiceDetail serviceDetail = new SalonServiceDetail("description", "name", 100L, 10);
//		Slot slot = new Slot( null, null, LocalDateTime.now(), Slot.SlotStatus.AVAILABLE, "foo",
//				Set.of(serviceDetail), null);
		Slot slot = Slot.builder()
				.availableServices(Set.of(serviceDetail))
				.build();
		Payment payment = Payment.builder()
				.amount(1234)
				.clientSecret("client-secret")
				.email("someone@somewhere.com")
				.firstName("foo")
				.lastName("bar")
				.intentId("intent-id")
				.phoneNumber("phone-no")
				.status(Payment.PaymentStatus.SUCCESS)
				.slot(slot)
				.selectedService(serviceDetail)
				.build();

		Payment persisted = testEntityManager.persist(payment);

		assertThat(persisted.getId()).isGreaterThan(0);
		assertThat(persisted.getSlot()).isEqualTo(slot);
		assertThat(persisted.getSelectedService()).isEqualTo(serviceDetail);
		assertThat(persisted.getCreated()).isCloseTo(LocalDateTime.now(), within(1, ChronoUnit.MINUTES));
		assertThat(persisted.getUpdated()).isCloseTo(LocalDateTime.now(), within(1, ChronoUnit.MINUTES));
	}


}