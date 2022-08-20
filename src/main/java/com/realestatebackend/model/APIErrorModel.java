package com.realestatebackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class APIErrorModel {

    private LocalDateTime time;

    private String error;

    private Map<String, String> message;
}
