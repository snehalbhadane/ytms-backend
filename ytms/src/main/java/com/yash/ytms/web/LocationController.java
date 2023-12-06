package com.yash.ytms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.Location;
import com.yash.ytms.service.LocationService;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {

@Autowired
private LocationService locationService;
	@GetMapping("/getLocations")
	public ResponseEntity<List<Location>> getAllLocation() {
		
		return ResponseEntity.ok(locationService.findAll());
	}
}

