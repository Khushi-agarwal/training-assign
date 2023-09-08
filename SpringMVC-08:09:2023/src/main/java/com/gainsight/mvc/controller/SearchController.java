package com.gainsight.mvc.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.FlightDAO;
import com.gainsight.mvc.entity.Flight;

@Controller

public class SearchController {
	@Autowired
	FlightDAO fdao;
	@GetMapping("/getFlights")
	public String getFlights(@RequestParam String source,@RequestParam String destination,Model model)
	{
		ArrayList<Flight> fl=null;
		
		fl=fdao.searchFlight(source, destination);
		//System.out.println(fl.size());
			model.addAttribute("fl",fl);
			return "Display";
		
	}
	

}
