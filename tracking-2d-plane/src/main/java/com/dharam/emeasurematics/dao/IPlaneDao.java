package com.dharam.emeasurematics.dao;

import java.util.List;

import com.dharam.emeasurematics.domain.PartObject;
import com.dharam.emeasurematics.domain.PartObjectDistance;
import com.dharam.emeasurematics.domain.Plane;

public interface IPlaneDao {

	
	List<Plane> getAllPlane();
	
	boolean isObjectPlaceable(long planeId, PartObject partObject);
	
	public List<PartObject> getDistanceBetweenPartObjects(long planeId, long id1, long id2);
	
	boolean isPartObjectPresent(long planeId, PartObject partObject);
	
}
