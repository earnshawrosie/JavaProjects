package com.payara.api.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payara.entity.BaggageClass;
import com.payara.logic.BaggageManager;
import com.payara.model.BaggageFees;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/baggage")
@Validated
public class BaggageController {

	@Autowired
	private BaggageManager baggageManager;

	@GetMapping(value = "/baggageClasses", produces = "application/json")
	public List<BaggageClass> getBaggageClassData() {
		return baggageManager.getAllBaggageClasses();
	}

	@GetMapping(value = "/calculatefee", produces = "application/json")
	public BaggageFees calculateFees(
			@RequestParam("weights") 
			@Size(min = 0, max = 5, message = "Only 5 items of luggage are permitted") 
			List<@Max(value = 25, message = "Luggage weight may not exceed 25kg") Double> weights) {
		return baggageManager.calculateBaggageFees(weights);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, Object> handleValidationExceptions2(
			ConstraintViolationException ex) {
		Map<String, Object> responseBody = new LinkedHashMap<String, Object>();
		responseBody.put("timestamp", new Date());
		responseBody.put("status", HttpStatus.BAD_REQUEST.value());
		responseBody.put("errors", ex.getConstraintViolations()
				.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()));
	    
		return responseBody;
	}
	
}
