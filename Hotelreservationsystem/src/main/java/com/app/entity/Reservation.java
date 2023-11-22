package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Reservation extends BaseEntity{
	@Column(nullable = false)
	private int roomNo;
	
	@Column
	private boolean isBooked;
	
	@Column
	private LocalDate bookingDate;
	
	@JoinColumn
	@ManyToOne
	private Guest guests;
	
	
	
	
}
