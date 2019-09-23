package com.aakash.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aakash.location.entities.Location;
import com.aakash.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repostiory;
	
	@Override
	public Location saveLocation(Location location) {
		return repostiory.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repostiory.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
        repostiory.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return repostiory.findById(id).get();
	}

	@Override
	public List<Location>getAllLocations() {
		return repostiory.findAll();
	}

}
