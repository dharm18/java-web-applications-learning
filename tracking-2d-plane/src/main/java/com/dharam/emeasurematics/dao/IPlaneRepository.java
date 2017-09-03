package com.dharam.emeasurematics.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dharam.emeasurematics.domain.Plane;

public interface IPlaneRepository extends JpaRepository<Plane, Long> {

}
