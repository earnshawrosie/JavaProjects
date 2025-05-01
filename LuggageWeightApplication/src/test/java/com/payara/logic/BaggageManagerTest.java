package com.payara.logic;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.payara.entity.BaggageClass;
import com.payara.model.BaggageFees;
import com.payara.model.BaggageType;
import com.payara.service.BaggageClassService;

import jakarta.inject.Inject;

@SpringBootTest
public class BaggageManagerTest {
	
	@MockitoBean
	@Inject
	private BaggageFeeLogic baggageFeeLogic;
	
	@MockitoBean
	@Inject
	private BaggageClassService baggageClassService;
	
	@Inject
	private BaggageManager baggageManager;

	@Test
	public void testGetBaggageClasses() throws Exception {
		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(10).setScale(2), BaggageType.HEAVY);
		
		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2);
		when(baggageManager.getAllBaggageClasses()).thenReturn(baggageClassList);
		
		baggageManager.getAllBaggageClasses();
		
		Mockito.verify(baggageClassService, times(1)).getAllBaggageClasses();
	}
	
	@Test
	public void testCalculateFees() throws Exception {
		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(10).setScale(2), BaggageType.HEAVY);
		
		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2);
		when(baggageManager.getAllBaggageClasses()).thenReturn(baggageClassList);
		
		List<Double> weights = Arrays.asList(6.9, 23.0, 4.5);
		
		BaggageFees fees = new BaggageFees();
		fees.setTotal(new BigDecimal(10.00));
		
		when(baggageFeeLogic.calculateFees(baggageClassList, weights)).thenReturn(fees);
		
		baggageManager.calculateBaggageFees(weights);
		
		Mockito.verify(baggageClassService, times(1)).getAllBaggageClasses();
		Mockito.verify(baggageFeeLogic, times(1)).calculateFees(baggageClassList, weights);
	}
}
