package com.app.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Reservationdto {
	
	private int roomNo;
	
	private boolean isBooked;
	
	private LocalDate bookingDate;
	
	private Long gid;
}
