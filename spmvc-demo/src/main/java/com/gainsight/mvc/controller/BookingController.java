package com.gainsight.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.BookingDAO;
import com.gainsight.mvc.dao.PassengerDAO;

@Controller
public class BookingController {
	@Autowired
	BookingDAO bookingdao;
	@Autowired
	PassengerDAO passengerdao;
	@GetMapping("/booking")
	public String addDetails(@RequestParam String bookingId,@RequestParam String flightId,@RequestParam String passengerId,@RequestParam String travelDate,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam Long mobile,Model model)
	{
		String message="Booking not added";
		if(bookingdao.addBookingDetails(bookingId, flightId, passengerId, travelDate) && passengerdao.addBookingDetails(passengerId, firstName, lastName, mobile, email))
		{	message="Booking added successfully";}

		model.addAttribute("message",message);
		//model.addAttribute("message",message);
		return "Display1";
	}

}
