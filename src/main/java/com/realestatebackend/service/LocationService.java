package com.realestatebackend.service;

import com.realestatebackend.constant.EntityStatusEnum.*;
import com.realestatebackend.customexception.DuplicatedEntityException;
import com.realestatebackend.customexception.NoSuchEntityException;
import com.realestatebackend.entity.LocationEntity;
import com.realestatebackend.model.LocationModel;
import com.realestatebackend.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    /**
     * create a location
     * @param model
     * @return created model
     */
    public LocationModel createLocation(LocationModel model) {
        //Check existed location
        if(locationRepository.existsLocationEntitiesByProvinceAndDistrictAndWard(model.getProvince(), model.getDistrict(), model.getWard())) {
            throw new DuplicatedEntityException("This location has been existed");
        }
        //Set id for model is null
        if(model.getId() != null) {
            model.setId(null);
        }

        //Prepare entity
        LocationEntity entity = new LocationEntity(model);
        entity.setStatus(LocationStatusEnum.ACTIVE.ordinal());

        //Save entity to DB
        LocationEntity savedEntity = locationRepository.save(entity);
        model = new LocationModel(savedEntity);

        return model;
    }

    /**
     * delete a location
     * @param id
     * @return delete model
     */
    public LocationModel deleteLocationModel(Integer id) {
        //Find location with id
        Optional<LocationEntity> deletedLocationOptional = locationRepository.findById(id);
        LocationEntity deletedLocationEntity = deletedLocationOptional.orElseThrow(() -> new NoSuchEntityException("Not found location"));

        //Set status for entity
        deletedLocationEntity.setStatus(LocationStatusEnum.DISABLE.ordinal());

        //Update status of location
        LocationEntity responseEntity = locationRepository.save(deletedLocationEntity);
        return new LocationModel(responseEntity);
    }

    /**
     * Find a location by id
     * @param id
     * @return found model
     */
    public LocationModel findLocationById(Integer id) {
        //Find location with id
        Optional<LocationEntity> searchedLocationOptional = locationRepository.findById(id);
        LocationEntity locationEntity = searchedLocationOptional.orElseThrow(() -> new NoSuchEntityException("Not found location"));
        return new LocationModel(locationEntity);
    }

    /**
     * Update location
     * @param id
     * @param locationModel
     * @return updated loation
     */
    public LocationModel updateLocation(Integer id, LocationModel locationModel) {
        //Find location with id
        Optional<LocationEntity> searchedLocationOptional = locationRepository.findById(id);
        LocationEntity searchedLocationEntity = searchedLocationOptional.orElseThrow(() -> new NoSuchEntityException("Not found location"));

        //Check existed location with province, district and ward then update model
        if(locationRepository.existsLocationEntitiesByProvinceAndDistrictAndWardAndIdNot(locationModel.getProvince(),
                locationModel.getDistrict(), locationModel.getWard(), id)) {
            throw  new DuplicatedEntityException("This location existed");
        }

        //Prepare entity for saving to DB
        locationModel.setId(id);

        //Save entity to DB
        LocationEntity savedEntity = locationRepository.save(new LocationEntity(locationModel));
        return new LocationModel(savedEntity);
    }

}
