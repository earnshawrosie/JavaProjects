package com.payara.service;

import java.util.List;

import com.payara.entity.BaggageClass;

public interface IBaggageClassService {

	BaggageClass addBaggageClass(BaggageClass baggageClass);
	List<BaggageClass> getAllBaggageClasses();
}
