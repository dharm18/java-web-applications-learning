package com.dharam.emeasurematics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Plane implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	@Column
	private long width;
	@Column
	private long height;
	
	@OneToMany(mappedBy = "plane" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PartObject> placedObjects = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getWidth() {
		return width;
	}
	public void setWidth(long width) {
		this.width = width;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	
	
	
	public List<PartObject> getPlacedObjects() {
		return placedObjects;
	}
	public void setPlacedObjects(List<PartObject> placedObjects) {
		this.placedObjects = placedObjects;
	}
	
	public void addPartObject(PartObject partObject){
		partObject.setPlane(this);
		placedObjects.add(partObject);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Plane [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}
	

}
