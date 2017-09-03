package com.dharam.emeasurematics.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dharam.emeasurematics.domain.PartObject;
import com.dharam.emeasurematics.domain.PartObjectDistance;
import com.dharam.emeasurematics.domain.Plane;

@Repository
public class PlaneDao implements IPlaneDao {

	
	@Autowired
	private EntityManager entityManager;
	
	
	
	
	@Override
	public boolean isObjectPlaceable(long planeId, PartObject partObject) {
		
		int count  = entityManager.createNativeQuery("select po.* From test.Plane p inner join test.part_object po on p.id = po.plane_id and p.id = ? "
				+ " where po.x+po.width <= ? or " //x1+w1 < x2
				+ "	? <= po.x  or " // x2+w2 < x1
				+ "	po.y + po.height <= ?  or " // y1+h1 < y2 
				+ " ? <= po.y "			   // y2 + h2 < y1	
				)
			.setParameter(1, planeId)
			.setParameter(2, partObject.getX())
			.setParameter(3, partObject.getX()+partObject.getWidth())
			.setParameter(4, partObject.getY())
			.setParameter(5, partObject.getY()+partObject.getHeight())
			.getResultList().size();
		
		return count > 0;
	}




	@Override
	public List<Plane> getAllPlane() {

		return entityManager.createQuery("from Plane", Plane.class).getResultList();
	}




	@Override
	public List<PartObject> getDistanceBetweenPartObjects(long planeId, long id1, long id2) {
		
		List<PartObject> parts = entityManager.createNativeQuery("select po.* From test.Plane p inner join test.part_object po on p.id = po.plane_id and p.id = ? "
				+ " where po.id in ( ? , ? ) ", PartObject.class)
			.setParameter(1, planeId)
			.setParameter(2, id1)
			.setParameter(3, id2)
			.getResultList();
		
		return parts;
	}




	@Override
	public boolean isPartObjectPresent(long planeId, PartObject partObject) {
		
		int count  = entityManager.createNativeQuery("select po.* From test.Plane p inner join test.part_object po on p.id = po.plane_id and p.id = ? "
				+ " where po.x = ? and po.y = ? "
				//+ "and po.height = ? and po.width = ?  "	
				)
			.setParameter(1, planeId)
			.setParameter(2, partObject.getX())
			.setParameter(3, partObject.getY())
			//.setParameter(4, partObject.getWidth())
			//.setParameter(5, partObject.getHeight())
			.getResultList().size();
		
		return (count > 0);
	}
	

	
	
}
