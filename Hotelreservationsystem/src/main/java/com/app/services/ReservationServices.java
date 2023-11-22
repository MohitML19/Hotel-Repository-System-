package com.app.services;

import java.util.List;

import com.app.dto.Reservationdto;
import com.app.entity.Guest;
import com.app.entity.Reservation;

public interface ReservationServices {

	List<Reservation> getAllReservations(Long id);
	
	String bookRooms(Reservationdto r);
	//Reservation bookRoom();
}
