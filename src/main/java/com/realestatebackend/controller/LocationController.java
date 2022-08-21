package com.realestatebackend.controller;

import com.realestatebackend.model.LocationModel;
import com.realestatebackend.model.PaginationRequestModel;
import com.realestatebackend.model.ResourceModel;
import com.realestatebackend.resolver.annotation.RequestPagingParam;
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

    /**
     * Find location by id
     * @param id
     * @return response entity contains model
     */
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LocationModel> findLocationById(@PathVariable @Min(0) Integer id) {
        LocationModel model = locationService.findLocationById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /**
     * Update location
     * @param id
     * @param requestModel
     * @return response entity contains model
     */
    @PutMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LocationModel> updateLocation(@PathVariable @Min(0) Integer id,
                                                        @Valid @RequestBody LocationModel requestModel) {
        LocationModel updatedModel = locationService.updateLocation(id, requestModel);
        return new ResponseEntity<>(updatedModel, HttpStatus.OK);
    }

    /**
     * Search location by province or district or ward
     * @param searchedValue
     * @param paginationRequestModel
     * @return resource data of location
     */
    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> searchLocations(@RequestParam(value = "searchedValue", defaultValue = "") String searchedValue,
                                                  @RequestPagingParam PaginationRequestModel paginationRequestModel) {
        ResourceModel<LocationModel> locationList = locationService.searchLocations(searchedValue, paginationRequestModel);
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }
}
