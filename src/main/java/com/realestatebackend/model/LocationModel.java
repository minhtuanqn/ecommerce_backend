package com.realestatebackend.model;

import com.realestatebackend.entity.LocationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;

@Component
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LocationModel {

    public LocationModel(LocationEntity entity) {
        this.id = entity.getId();
        this.province = entity.getProvince();
        this.district = entity.getDistrict();
        this.ward = entity.getWard();
        this.status = entity.getStatus();
    }

    private Integer id;

    @NotNull(message = "province.null")
    private String province;

    @NotNull(message = "district.null")
    private String district;

    @NotNull(message = "ward.null")
    private String ward;

    @NotNull(message = "location_status.null")
    private int status;
}
