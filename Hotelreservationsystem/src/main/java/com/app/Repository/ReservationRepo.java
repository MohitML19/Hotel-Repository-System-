package com.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Guest;
import com.app.entity.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>{
	List<Reservation> findByGuests(Guest g);
	
	Optional<Reservation> findByRoomNo(int num);
}
