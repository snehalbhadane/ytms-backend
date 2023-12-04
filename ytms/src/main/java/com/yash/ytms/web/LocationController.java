package com.yash.ytms.web;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.constants.LocationEnum;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {


	@GetMapping("/getLocations")
	public ResponseEntity<List<String>> getAllLocation() {
		return ResponseEntity.ok(Stream.of(LocationEnum.LOCATION.values()).map(Enum::name).collect(Collectors.toList()));
	}
}

