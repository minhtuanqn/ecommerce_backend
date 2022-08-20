package com.realestatebackend.controller;

import com.realestatebackend.model.LocationModel;
import com.realestatebackend.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
@RequestMapping(path = "/locations")
public class LocationController {

    private LocationService locationService;

    public  LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    /**
     * Create new location
     * @param requestModel
     * @return response entity contains created model
     */
    @PostMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LocationModel> createLocation(@Valid @RequestBody LocationModel requestModel) {
        LocationModel savedModel = locationService.createLocation(requestModel);
        return new ResponseEntity<>(savedModel, HttpStatus.OK);
    }

    /**
     * delete location
     * @param id
     * @return response entity contains deleted model
     */
    @DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LocationModel> deleteLocation(@PathVariable @Min(0) Integer id) {
        LocationModel deletedModel = locationService.deleteLocationModel(id);
        return new ResponseEntity<>(deletedModel, HttpStatus.OK);
    }
}
