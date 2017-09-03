package com.dharam.emeasurematics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dharam.emeasurematics.dao.IPartObjectRepository;
import com.dharam.emeasurematics.dao.IPlaneDao;
import com.dharam.emeasurematics.dao.IPlaneRepository;
import com.dharam.emeasurematics.domain.PartObject;
import com.dharam.emeasurematics.domain.PartObjectDistance;
import com.dharam.emeasurematics.domain.Plane;

@Service
public class PlaneService implements IPlaneService {

	@Autowired
	private IPlaneRepository planeRepository;
	
	@Autowired
	private IPlaneDao planeDao;
	
	@Override
	public Plane create(Plane plane) {
		return planeRepository.save(plane);
	}
	
	@Override
	public boolean placeObject(long planeId, PartObject partObject) {
		Plane plane = planeRepository.findOne(planeId);
		
		//
		if(plane.getWidth() < partObject.getX()+partObject.getWidth() || plane.getHeight() < partObject.getY()+partObject.getHeight())
			return false;

		// already exists 
		if(planeDao.isPartObjectPresent(planeId, partObject)){
			return false;
		}
		
		if(plane.getPlacedObjects().size() == 0 || planeDao.isObjectPlaceable(planeId, partObject)){
			
			plane.addPartObject(partObject);
			
			planeRepository.save(plane);
			
			return true;
		}
		
		return false;
	}

	@Override
	public List<Plane> getAllPlane() {
		return planeRepository.findAll();
	}

	@Override
	public Plane getPlane(long planeId) {
		return planeRepository.findOne(planeId);
	}

	@Override
	public PartObjectDistance getDistanceBetweenPartObjects(long planeId, long id1, long id2) {
		List<PartObject> parts = planeDao.getDistanceBetweenPartObjects(planeId, id1, id2);
		
		PartObjectDistance distance = new PartObjectDistance();
		if(parts.size()== 2){
			
			PartObject o1 = parts.get(0);
			PartObject o2 = parts.get(1);
			
			distance.setxDistance(Math.abs( ((o1.getX()+o1.getX()+o1.getWidth())/2) -  ((o2.getX()+o2.getX()+o2.getWidth())/2)));
			distance.setyDistance(Math.abs( ((o1.getY()+o1.getY()+o1.getHeight())/2) -  ((o2.getY()+o2.getY()+o2.getHeight())/2)));
		}
		
		return distance;
		
	}


}
