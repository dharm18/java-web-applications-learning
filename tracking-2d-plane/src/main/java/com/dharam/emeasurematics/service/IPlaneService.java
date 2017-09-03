package com.dharam.emeasurematics.service;

import java.util.List;

import com.dharam.emeasurematics.domain.PartObject;
import com.dharam.emeasurematics.domain.PartObjectDistance;
import com.dharam.emeasurematics.domain.Plane;

public interface IPlaneService {

	List<Plane> getAllPlane();
	
	Plane getPlane(long planeId);
	
	Plane create(Plane plane); 
	
	boolean placeObject(long planeId, PartObject partObject);

	PartObjectDistance getDistanceBetweenPartObjects(long planeId, long id1, long id2);
	
}
