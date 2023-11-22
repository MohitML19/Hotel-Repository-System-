
package com.app.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.GuestRepo;
import com.app.Repository.ReservationRepo;
import com.app.dto.Guestdto;
import com.app.entity.Guest;
import com.app.entity.Reservation;


@Service
@Transactional
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepo guestRepo;
	@Autowired
	private ModelMapper map;
	@Autowired
	private ReservationRepo resRepo;
	
	@Override
	public String loginGuest(String email, String password) {
		// TODO Auto-generated method stub
		List<Guest> list = guestRepo.findAll();
		String msg = "Wrong email or password";
		for(Guest g : list) {
			if(g.getEmail().equals(email) && g.getPassword().equals(password)) {
				msg = "Login Successful";
			}
		}
		return msg;
	}

	@Override
	public String Registerguest(Guestdto r) {
		Guest s=map.map(r, Guest.class);
		
		guestRepo.save(s);
		return "Register Sucessfull";
	}
	
	@Override
	public String cancelReservations(Long gid, Long rid) {
		Guest g = guestRepo.findById(gid).orElseThrow();
		
		Reservation r = resRepo.findById(rid).orElseThrow();
		
		g.cancelReservation(r);
		
		resRepo.deleteById(rid);
		
		return "Reservation cancelled";
		
	}

	@Override
	public String updateReservationDate(String d, int num) {
		
		Reservation r = resRepo.findByRoomNo(num).orElseThrow();
		LocalDate d1 = LocalDate.parse(d);
		if(r!=null) {
			r.setBookingDate(d1);
			return "Reservation date updated";
		}
		
		
		
		return "Room not found";
	}
	
	
	
	
}
/*
@Override
public String loginFarmer(Farmer request) {
	//Farmer f =farmerRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword()).orElseThrow(()-> new ResourceNotFoundException("Farmer not found"));
	List<Farmer> flist = farmerRepo.findAll();
	String passMsg = "pass" ;
	String failMsg = "fail" ;
	for(Farmer f : flist) {
		if(f.getUsername().equals(request.getUsername()) && f.getPassword().equals(request.getPassword())) {
			return passMsg;
		}
	}
	
	return failMsg;
}
@Override
public String addProduct(Product product) {
	String s = "Product not added";
	
	//int i = product.getFid().getFid();
	
	prodRepo.save(product);
	Farmer f = product.getFid();
//	f.addProduct(product);
	
	return "Product added";
}*/