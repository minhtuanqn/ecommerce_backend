package com.realestatebackend.repository;

import com.realestatebackend.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity, Integer>, JpaSpecificationExecutor<LocationEntity> {
    boolean existsLocationEntitiesByProvinceAndAndDistrictAndWard(String province, String district, String ward);
}
