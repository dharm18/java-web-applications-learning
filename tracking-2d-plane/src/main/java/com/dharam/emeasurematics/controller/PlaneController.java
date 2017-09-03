package com.dharam.emeasurematics.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dharam.emeasurematics.domain.PartObject;
import com.dharam.emeasurematics.domain.PartObjectDistance;
import com.dharam.emeasurematics.domain.Plane;
import com.dharam.emeasurematics.service.IPlaneService;

@RestController
public class PlaneController {

	@Autowired
	IPlaneService planeService;
	
	@RequestMapping(value="/plane/{id}/placeObject",method=RequestMethod.POST)
	public boolean placeObject(@PathVariable long id, @RequestBody PartObject partObject){
		return planeService.placeObject(id, partObject);
	}
	
	@RequestMapping(value="/plane/{id}/placedObjects",method=RequestMethod.GET)
	public List<PartObject> placeObject(@PathVariable long id){
		Plane plane = planeService.getPlane(id);
		if(plane != null){
			return plane.getPlacedObjects();
		}
		return new ArrayList<PartObject>();
	}
	
	@RequestMapping(value="/plane/{id}/distanceBetweenObjects",method=RequestMethod.GET)
	public @ResponseBody PartObjectDistance placeObject(@PathVariable("id") long planeId, @RequestParam long id1, @RequestParam long id2){
		return planeService.getDistanceBetweenPartObjects(planeId,id1,id2);
	}
	
	
	@RequestMapping(value = "/plane",method=RequestMethod.POST)
	public @ResponseBody Plane createPlane(@RequestBody Plane plane) {
		
		return planeService.create(plane);
		
	}
	
	@RequestMapping(value = "/plane",method=RequestMethod.GET)
	public @ResponseBody List<Plane> getPlane() {
		
		return planeService.getAllPlane();
		
	}
	
	
	
	
}
