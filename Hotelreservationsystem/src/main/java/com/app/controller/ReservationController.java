package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Reservationdto;
import com.app.entity.Guest;
import com.app.entity.Reservation;
import com.app.services.GuestService;
import com.app.services.ReservationServices;

@RestController
public class ReservationController {

	@Autowired
	private GuestService guestSer;
	
	@Autowired
	private ReservationServices resSer;
	
	
	@PostMapping("/Bookroom")
	public String bookRooms(@RequestBody Reservationdto r) {
		
		return resSer.bookRooms(r);
	}
	
	
	
	
	
}
