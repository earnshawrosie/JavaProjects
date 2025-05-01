package com.payara.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.payara.entity.Passenger;
import com.payara.service.PassengerService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private PassengerService passengerService;
	
	@GetMapping(value = "/")
	public String tickets(Model model) {
		return "tickets";
	}
	
	@GetMapping(value = "/alltickets")
	public String getAllTickets(Model model) {
		List<Passenger> passengers = passengerService.getAllPassengers();
	    model.addAttribute("tickets", passengers);
		return "alltickets";
	}
	
	@GetMapping("/select")
    public String selectTicket(
            Model model,
            RedirectAttributes attributes,
            @RequestParam Long id
            ) {
      
       Optional<Passenger> passenger = passengerService.getPassenger(id);
       if (passenger.isPresent()) {
    	   model.addAttribute("passenger", passenger.get());
    	   return "processTicket";
       } else {
    	   return "redirect:alltickets";
       } 
    }
}
