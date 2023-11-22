package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Guestdto;
import com.app.entity.Guest;
import com.app.entity.Reservation;
import com.app.services.GuestService;
import com.app.services.ReservationServices;

@RestController
@RequestMapping("/guests")
public class GuestController {
	@Autowired
	private GuestService guestSer;
	
	@Autowired
	private ReservationServices resSer;
	
	@PostMapping("/Registerguest")
	public String bookRooms(@RequestBody Guestdto g) {
		System.out.println(g);
		return guestSer.Registerguest(g);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/reservationbooked/{id}")
	public List<Reservation> getAllReservations(@PathVariable Long id) {
		
		return resSer.getAllReservations(id);
	}
	
	
	
	
	@DeleteMapping("/{gid}/{rid}")
	public String removeReservation(@PathVariable Long gid, @PathVariable Long rid) {
		return guestSer.cancelReservations(gid, rid);
		
	}
	
	@PutMapping("/{d}/{num}")
	public String updateDate(@PathVariable String d, @PathVariable int num) {
		
		return guestSer.updateReservationDate(d, num);
	}
	
}
