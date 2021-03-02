package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.priyanka.model.Twitt;

public interface TwittRespository extends JpaRepository<Twitt, Integer> {
public Twitt findById(int id);
}
