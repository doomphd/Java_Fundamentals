package com.codingdojo.javaexam.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.javaexam.models.Show;
import com.codingdojo.javaexam.repositories.ShowRepository;

@Service
public class ShowService {

	private final ShowRepository ShowRepo;
	
	public ShowService(ShowRepository showRepo) {
		this.ShowRepo =  showRepo;
	}
	
	
	// ****** find all ********
	public List<Show> allShows(){
		return ShowRepo.findAll();
	}
	
	// ****** CREATE ********
	public Show addShow(Show show) {
		// if the created Show has no id, MySql will create a new instance
		return ShowRepo.save(show);
	}
	
	// ****** SHOW ONE *******
	public Show findOneShow(Long id) {
		Optional<Show> optionalShow = ShowRepo.findById(id);
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		}else {
			return null;
		}
	}
	
	// ****** EDIT ********
	public Show editShow(Show show) {
		// if the created Show has no id, MySql will create a new instance
		return ShowRepo.save(show);
	}
	
	// ****** DELETE ********
	public void deleteShow(Long id) {
		ShowRepo.deleteById(id);
	}



	
}