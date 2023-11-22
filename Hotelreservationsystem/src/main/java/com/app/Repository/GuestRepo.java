package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Guest;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Long> {

}
