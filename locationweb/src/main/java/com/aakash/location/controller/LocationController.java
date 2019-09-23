package com.aakash.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aakash.location.entities.Location;
import com.aakash.location.repos.LocationRepository;
import com.aakash.location.service.LocationService;
import com.aakash.location.util.EmailUtil;
import com.aakash.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	LocationService service;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationsaved = service.saveLocation(location);
		String msg = "location saved with id " +locationsaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("aakashjethva08@gmail.com", "Location saved", "Location saved successfully");
		return "createLocation";
		
	}
		
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
	     List<Location> locations = service.getAllLocations();
	     modelMap.addAttribute("locations", locations);
	     return "displayLocations";
		 
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
		
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
		
	}
	
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
	
	
	
	
}