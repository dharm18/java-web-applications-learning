package com.dharam.emeasurematics.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dharam.emeasurematics.domain.PartObject;

public interface IPartObjectRepository extends JpaRepository<PartObject, Integer> {

}
