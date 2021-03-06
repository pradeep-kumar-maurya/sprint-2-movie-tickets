package com.cap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.bean.Seats;
import com.cap.dao.SeatsDaoI;

@Service
@Transactional
public class SeatsService implements SeatsServiceI {
	
	@Autowired
	private SeatsDaoI dao;

	@Override
	public List<Seats> getSeats() {
		List<Seats> list = dao.findAll();
		return list;
	}

	@Override
	public String updateSeats(Seats seat_obj) {
		boolean bool = dao.existsById(seat_obj.getSno());
		if(bool == true) {
			dao.save(seat_obj);
			return "seats were updated successfully!!";
		}
		else {
			return "sorry, seats were not updated";
		}
	}
}
