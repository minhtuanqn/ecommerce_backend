package com.realestatebackend.metamodel;

import com.realestatebackend.entity.LocationEntity;

import javax.persistence.metamodel.SingularAttribute;

public class LocationEntity_ {
    public static volatile SingularAttribute<LocationEntity, Integer> id;
    public static volatile SingularAttribute<LocationEntity, String> province;
    public static volatile SingularAttribute<LocationEntity, String> district;
    public static volatile SingularAttribute<LocationEntity, String> ward;
    public static volatile SingularAttribute<LocationEntity, Integer> status;
    public static final String ID = "id";
    public static final String PROVINCE = "province";
    public static final String DISTRICT = "district";
    public static final String WARD = "ward";
    public static final String STATUS = "status";
}
