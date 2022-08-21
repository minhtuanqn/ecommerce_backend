package com.realestatebackend.repository;

import com.realestatebackend.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity, Integer>, JpaSpecificationExecutor<LocationEntity> {
    boolean existsLocationEntitiesByProvinceAndDistrictAndWard(String province, String district, String ward);
    boolean existsLocationEntitiesByProvinceAndDistrictAndWardAndIdNot(String province, String district, String ward, Integer id);
}
