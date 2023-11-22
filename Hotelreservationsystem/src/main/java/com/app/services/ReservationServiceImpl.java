package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.Repository.GuestRepo;
import com.app.Repository.ReservationRepo;
import com.app.dto.Reservationdto;
import com.app.entity.Guest;
import com.app.entity.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationServices {

	@Autowired
	private ReservationRepo resRepo;
	
	@Autowired
	private ModelMapper map;
	@Autowired
	private GuestRepo guestRepo;
	
	public String bookRooms(Reservationdto r)
	{
		Guest g=guestRepo.findById(r.getGid()).orElseThrow();
		
		Reservation room=map.map(r, Reservation.class);
		
		g.addReservation(room);
		
		return "Room Booked Sucessfully";	
	}
	@Override
	public List<Reservation> getAllReservations(Long id) {
		Guest g = guestRepo.findById(id).orElseThrow();
		// TODO Auto-generated method stub
		return resRepo.findByGuests(g);
	}
	
	
	
	
	
}
