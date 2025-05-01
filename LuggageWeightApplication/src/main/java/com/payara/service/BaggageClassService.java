package com.payara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payara.entity.BaggageClass;
import com.payara.repository.BaggageClassRepository;

@Service
public class BaggageClassService implements IBaggageClassService {
	
	@Autowired
	private BaggageClassRepository baggageClassRepository;

	@Override
	public List<BaggageClass> getAllBaggageClasses() {
		return baggageClassRepository.findAll();
	}

	@Override
	public BaggageClass addBaggageClass(BaggageClass baggageClass) {
		return baggageClassRepository.save(baggageClass);
	}

}
