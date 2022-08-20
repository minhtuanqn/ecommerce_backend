package com.realestatebackend.entity;

import com.realestatebackend.model.LocationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LocationEntity {

    public LocationEntity(LocationModel model) {
        this.id = model.getId();
        this.province = model.getProvince();
        this.district = model.getDistrict();
        this.ward = model.getWard();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "ward")
    private String ward;

    @Column(name = "status")
    private int status;
}
