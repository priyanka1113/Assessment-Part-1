package com.priyanka.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.model.Twitt;
import com.priyanka.repository.TwittRespository;
import com.priyanka.service.TwittService;

@RestController
public class TwittController {
	@Autowired
	TwittRespository repo;

	@Autowired
	private TwittService service;

	@GetMapping("/twitt")
	public List<Twitt> getTwitts() {
		return service.listtAll();
	}

	@GetMapping("/twitt/{id}")
	public ResponseEntity<Twitt> get(@PathVariable Integer id) {
		try {
			Twitt twitt = service.get(id);
			return new ResponseEntity<Twitt>(twitt, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Twitt>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/twitt")
	public void postTwitt(@RequestBody Twitt twitt) {
		service.create(twitt);
	}

	@PutMapping("/twitt/id}")
	public ResponseEntity<?> updateTwitt(@RequestBody Twitt twitt, @PathVariable Integer id) {
		try {
			Twitt twittexist = service.get(id);
			service.create(twitt);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/twitt/id}")
	public void deleteTwitt(@PathVariable Integer id) {
		service.deleteTwitt(id);
	}

}
