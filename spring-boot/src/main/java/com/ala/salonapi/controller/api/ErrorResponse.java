package com.ala.salonapi.controller.api;

import java.util.List;

import lombok.Value;

@Value
public class ErrorResponse {

	String type;
	String message;
	List<ErrorItem> errors;
}
