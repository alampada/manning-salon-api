package com.ala.salonapi.configuration;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = Salon.class)
@TestPropertySource("classpath:application-test.properties")
class SalonTest {

	@Autowired
	Salon salon;

	@Test
	public void shouldReadFromFile() {
		assertThat(salon.getName()).isEqualTo("AR Salon and Day Spa Services");
	}

}