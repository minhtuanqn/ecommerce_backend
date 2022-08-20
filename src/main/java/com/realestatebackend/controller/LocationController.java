package com.realestatebackend.controller;

import com.realestatebackend.model.LocationModel;
import com.realestatebackend.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

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
    public ResponseEntity<Object> createDepartment(@Valid @RequestBody LocationModel requestModel) {
        LocationModel savedModel = locationService.createLocation(requestModel);
        return new ResponseEntity<>(savedModel, HttpStatus.OK);
    }
}
