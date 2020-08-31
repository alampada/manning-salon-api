package com.ala.salonapi.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDateTime confirmedAt;

	private LocalDateTime lockedAt;

	private LocalDateTime slotFor;

	private SlotStatus status;

	private String stylistName;

	@ManyToMany
	private Set<SalonServiceDetail> availableServices;

	@ManyToOne
	private SalonServiceDetail selectedService;
}

enum  SlotStatus {
	AVAILABLE,LOCKED,CONFIRMED,CANCELLED
}
