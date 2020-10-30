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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Data
@Builder
public class Slot {

	public enum  SlotStatus {
		AVAILABLE,LOCKED,CONFIRMED,CANCELLED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDateTime confirmedAt;

	private LocalDateTime lockedAt;

	private LocalDateTime slotFor;

	private SlotStatus status;

	private String stylistName;

	@ManyToMany
	@JsonIgnore
	private Set<SalonServiceDetail> availableServices;

	@ManyToOne
	@JsonIgnore
	private SalonServiceDetail selectedService;
}


