package com.gainsight.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.DisplayDAO;
import com.gainsight.mvc.entity.Bookings;

@Controller
public class BookingDisplayController {
	
	@Autowired
	DisplayDAO displaydao;
	@GetMapping("/display")
	public String displaydetails(@RequestParam String bookingId,Model model)
	{
		Bookings b=displaydao.display(bookingId);
		String message=b.getBookingId()+ b.getFlightId()+b.getPassengerId()+b.getTravelDate();
		model.addAttribute("message", message);	
		return "bookdisplay";
	}

}
