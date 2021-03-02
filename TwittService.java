package com.priyanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.priyanka.model.Twitt;
import com.priyanka.repository.TwittRespository;

@Service
public class TwittService {
	@Autowired
	private TwittRespository repo;

	public List<Twitt> listtAll() {
		return repo.findAll();

	}

	public void create(Twitt twitt) {
		repo.save(twitt);
	}

	public Twitt get(Integer id) {
		return repo.findById(id).get();
	}

	public void deleteTwitt(Integer id) {
		repo.deleteById(id);
	}
}
