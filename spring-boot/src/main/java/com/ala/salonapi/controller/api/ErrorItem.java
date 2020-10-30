package com.ala.salonapi.controller.api;

import lombok.Value;

@Value
public class ErrorItem {

	String field;
	Object rejectedValue;
	String message;
}
