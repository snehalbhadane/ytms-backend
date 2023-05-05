package com.yash.ytms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.Trainer;
import com.yash.ytms.serviceImpl.TrainerServiceImpl;

@RestController
@RequestMapping("/tariner")
public class TrainerController {
	
	@Autowired
	TrainerServiceImpl trainerServiceImpl;
	
	@PostMapping("/")
	public Trainer saveTrainerDeatils(@RequestBody Trainer trainer) {
		
		System.out.println(trainer);
		
		return trainerServiceImpl.saveTrainerDeatils(trainer);
		
	
		
	}

}
