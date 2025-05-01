package com.payara.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.payara.api.controller.PassengerController;
import com.payara.entity.Passenger;
import com.payara.service.PassengerService;

@ContextConfiguration(classes ={PassengerControllerTest.TestConfig.class})
@WebMvcTest(value = PassengerController.class)
@AutoConfigureMockMvc
public class PassengerControllerTest {
	
	@Configuration
	public static class TestConfig {

	    @Bean
	    public PassengerController controller() {
	        return new PassengerController();
	    }
	}

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private PassengerService passengerService;

	private static final String passengerJson = "[{\"id\":null,\"firstName\":\"Test\",\"lastName\":\"Passenger\",\"passportNumber\":\"PassportNum\","
			+ "\"numberOfBags\":4},{\"id\":null,\"firstName\":\"Test\",\"lastName\":\"Passenger2\",\"passportNumber\""
			+ ":\"PassportNum2\",\"numberOfBags\":1}]";

	@Test
	void shouldGetPassengerList() throws Exception {

		Passenger passenger1 = new Passenger("Test", "Passenger", "PassportNum", 4);
		Passenger passenger2 = new Passenger("Test", "Passenger2", "PassportNum2", 1);

		List<Passenger> passengerList = Arrays.asList(passenger1, passenger2);

		when(passengerService.getAllPassengers()).thenReturn(passengerList);
		this.mockMvc.perform(get("/api/passenger/passengers")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(passengerJson)));
	}
}
