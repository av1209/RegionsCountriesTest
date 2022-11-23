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

public class regionsController {
	
	@Autowired
	private regionsRepository regRepo;
	
	@GetMapping("/regions")
	public List <regions> getAllregions(){
		return regRepo.findAll();
		}
	
	@GetMapping("/regions/{id}")
	public Optional <regions> getRegionsById(@PathVariable String id){
		return regRepo.findById(id);
	}
	
	@PostMapping("/regions")
	public regions saveRegions(@RequestBody regions region) {
		return regRepo.save(region);
	}
	
	@PutMapping("/regions/{id}")
	public regions update(@PathVariable String id,@Validated @RequestBody regions region) {
		region.setId(id);
		return regRepo.save(region);
	}
	
	@DeleteMapping("/regions/{id}")
	public void deleteRegion(@PathVariable String id) {
		regRepo.deleteById(id);
	}

}

