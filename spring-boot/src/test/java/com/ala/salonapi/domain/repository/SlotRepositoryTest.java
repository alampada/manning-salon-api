package com.ala.salonapi.domain.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import com.ala.salonapi.domain.SalonServiceDetail;
import com.ala.salonapi.domain.Slot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class SlotRepositoryTest {

	@Autowired
	private SlotRepository testObject;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testFindSlotsByAvailableServicesAndStatusAndSlotForBetween() {
		SalonServiceDetail serviceDetail = new SalonServiceDetail("description", "name", 100L, 10);
		SalonServiceDetail serviceDetail2 = new SalonServiceDetail("description2", "name2", 100L, 10);
		testEntityManager.persist(serviceDetail);
		testEntityManager.persist(serviceDetail2);

		Slot slot = Slot.builder()
				.slotFor(LocalDateTime.now())
				.status(Slot.SlotStatus.AVAILABLE)
				.availableServices(Set.of(serviceDetail))
				.build();

		Slot slot2 = Slot.builder()
				.slotFor(LocalDateTime.now())
				.status(Slot.SlotStatus.AVAILABLE)
				.availableServices(Set.of(serviceDetail2))
				.build();

		testEntityManager.persist(slot);
		testEntityManager.persist(slot2);

		List<Slot> result = testObject.findSlotsByAvailableServicesAndStatusAndSlotForBetween(serviceDetail, Slot.SlotStatus.AVAILABLE,
				LocalDateTime.of(LocalDate.now(), LocalTime.MIN), LocalDateTime.of(LocalDate.now(), LocalTime.MAX));

		assertThat(result).size().isEqualTo(1);
		assertThat(result.get(0)).isEqualTo(slot);
	}

}