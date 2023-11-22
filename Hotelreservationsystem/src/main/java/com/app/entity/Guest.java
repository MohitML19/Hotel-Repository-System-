package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Guest extends BaseEntity {
	@Column(length = 30)
	private String firstname;
	
	@Column(length = 30)
	private String lastname;
	
	@Column(unique = true , nullable = false)
	private String email;
	
	@Column(length = 30 , unique = true , nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "guests" , cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
	
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public void addReservation(Reservation r ) {
		reservations.add(r);
		r.setGuests(this);
	}
	
	public void cancelReservation(Reservation r) {
		reservations.remove(r);
		r.setGuests(null);
	}
	

}
