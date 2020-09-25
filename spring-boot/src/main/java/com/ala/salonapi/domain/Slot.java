package com.ala.salonapi.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Data
public class Slot {

	public enum  SlotStatus {
		AVAILABLE,LOCKED,CONFIRMED,CANCELLED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private final LocalDateTime confirmedAt;

	private final LocalDateTime lockedAt;

	private final LocalDateTime slotFor;

	private final SlotStatus status;

	private final String stylistName;

	@ManyToMany
	@JsonIgnore
	private final Set<SalonServiceDetail> availableServices;

	@ManyToOne
	@JsonIgnore
	private final SalonServiceDetail selectedService;
}


