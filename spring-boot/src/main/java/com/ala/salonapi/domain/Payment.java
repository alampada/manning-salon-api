package com.ala.salonapi.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@AllArgsConstructor
@Data
@Builder
public class Payment {

	public enum PaymentStatus {
		SUCCESS,
		FAILED;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long amount;

	private String clientSecret;

	@CreationTimestamp
	private LocalDateTime created;

	private String email;

	private String firstName;

	private String lastName;

	private String intentId;

	private String phoneNumber;

	private PaymentStatus status;

	@UpdateTimestamp
	private LocalDateTime updated;

	@OneToOne
	private Slot slot;

	@OneToOne
	private SalonServiceDetail selectedService;
}
