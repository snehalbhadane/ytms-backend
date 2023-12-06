package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.Location;
import com.yash.ytms.model.Role;
import com.yash.ytms.repo.LocationRepository;
import com.yash.ytms.repo.RoleRepository;
import com.yash.ytms.service.LocationService;
import com.yash.ytms.service.RoleService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}


	

}
