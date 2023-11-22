package com.app.services;

import java.time.LocalDate;

import com.app.dto.Guestdto;
import com.app.entity.Guest;
import com.app.entity.Reservation;

public interface GuestService {
	String loginGuest(String email, String password);
	
	String Registerguest(Guestdto r);
	
	String cancelReservations(Long gid, Long rid);
	
	String updateReservationDate(String d, int num);
}
