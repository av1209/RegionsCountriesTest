package com.example.training;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")

public class CountriesController {
	
	@Autowired
	private CountriesRepository cRepo;
	
	@GetMapping("/countries")
	public List <Countries> getAllCountries(){
		return cRepo.findAll();
	}
	
	@GetMapping("/countries/{id}")
	public Optional <Countries> getCountriesById(@PathVariable String id){
		return cRepo.findById(id);
	}
	
	@PostMapping("/countries")
	public Countries saveCountries(@RequestBody Countries countries) {
		return cRepo.save(countries);
	}
	
	@PutMapping("/countries/{id}")
	public Countries update(@PathVariable String id,@Validated @RequestBody Countries countries) {
		countries.setId(id);
		return cRepo.save(countries);
	}
	
	@DeleteMapping("/countries/{id}")
	public void deleteCountries(@PathVariable String id) {
		cRepo.deleteById(id);
	}
}

