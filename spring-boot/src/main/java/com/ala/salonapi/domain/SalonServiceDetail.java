package com.ala.salonapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class SalonServiceDetail {

	@Id
	private int id;

	private String description;

	private String name;

	private int price;

	private int time_in_minutes;
}
