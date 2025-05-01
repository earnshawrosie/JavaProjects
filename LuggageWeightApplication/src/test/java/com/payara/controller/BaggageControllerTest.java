package com.payara.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.payara.api.controller.BaggageController;
import com.payara.entity.BaggageClass;
import com.payara.logic.BaggageFeeLogic;
import com.payara.logic.BaggageManager;
import com.payara.model.BaggageFees;
import com.payara.model.BaggageType;

@ContextConfiguration(classes ={BaggageControllerTest.TestConfig.class})
@WebMvcTest(value = BaggageController.class)
@AutoConfigureMockMvc
public class BaggageControllerTest {
	
	@Configuration
	public static class TestConfig {

	    @Bean
	    public BaggageController controller() {
	        return new BaggageController();
	    }
	}

	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private BaggageManager baggageManager;
	
	@MockitoBean
	private BaggageFeeLogic baggageFeeLogic;
	
	private static final String baggageJson = 
			"[{\"id\":null,\"minWeight\":0.0,\"maxWeight\":7.0,\"fee\":10.00,\"baggageType\":\"LIGHT\"},"
			+ "{\"id\":null,\"minWeight\":7.0,\"maxWeight\":25.0,\"fee\":10.00,\"baggageType\":\"HEAVY\"}]";
		
	@Test
	void shouldGetBaggageClassList() throws Exception {
		
		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(10).setScale(2), BaggageType.HEAVY);
		
		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2);
		when(baggageManager.getAllBaggageClasses()).thenReturn(baggageClassList);
		
		this.mockMvc.perform(get("/api/baggage/baggageClasses")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(baggageJson)));
	}
	
	@Test
	void shouldCalculateFees() throws Exception {
		
		List<Double> weights = Arrays.asList(6.9, 23.0, 4.5);
	
		BaggageFees fees = new BaggageFees();
		fees.setTotal(new BigDecimal(10.00));
		
		when(baggageManager.calculateBaggageFees(weights)).thenReturn(fees);
		mockMvc.perform(get("/api/baggage/calculatefee?weights={weight1}&weights={weight2}&weights={weight3}", 6.9, 23.0, 4.5))
			.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void shouldFailValidationForOverweightBag() throws Exception {
		
		List<Double> weights = Arrays.asList(6.9, 27.45);
	
		BaggageFees fees = new BaggageFees();
		fees.setTotal(new BigDecimal(10.00));
		
		when(baggageManager.calculateBaggageFees(weights)).thenReturn(fees);
		mockMvc.perform(get("/api/baggage/calculatefee?weights={weight1}&weights={weight2}", 6.9, 27.45))
			.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	void shouldFailValidationForTooManyBags() throws Exception {
		
		List<Double> weights = Arrays.asList(6.9, 23.0, 4.5, 11.0, 18.6, 5.7);
	
		BaggageFees fees = new BaggageFees();
		fees.setTotal(new BigDecimal(10.00));
		
		when(baggageManager.calculateBaggageFees(weights)).thenReturn(fees);
		mockMvc.perform(get("/api/baggage/calculatefee?weights={weight1}&weights={weight2}"
				+ "&weights={weight3}&weights={weight4}&weights={weight5}&weights={weight6}",
				6.9, 23.9, 4.5, 11.0, 18.6, 5.7))
			.andDo(print()).andExpect(status().isBadRequest());
	}
}
