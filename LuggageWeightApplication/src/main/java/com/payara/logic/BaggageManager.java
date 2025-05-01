package com.payara.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payara.entity.BaggageClass;
import com.payara.model.BaggageFees;
import com.payara.service.BaggageClassService;

@Component
public class BaggageManager {

	@Autowired 
	private BaggageClassService baggageClassService;
	
	@Autowired
	private BaggageFeeLogic baggageFeeLogic;
	
	public List<BaggageClass> getAllBaggageClasses() {
		return baggageClassService.getAllBaggageClasses();
	}
	
	public BaggageFees calculateBaggageFees(List<Double> baggageWeights) {
		return baggageFeeLogic.calculateFees(getAllBaggageClasses(), baggageWeights);
	}
}
