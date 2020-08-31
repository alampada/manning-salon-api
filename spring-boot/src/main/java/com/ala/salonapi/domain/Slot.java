package com.ala.salonapi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Slot {

	@Id
	private int id;

	private Date confirmedAt;

	private Date lockedAt;

	private Date slotFor;

	private int status;

	private String stylistName;

	//selected service id
}
