package com.module.intercom.dao;

import com.module.intercom.model.enums.DistanceUnitEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * View.
 */
@Data
@Builder
public class CustomerDao {
    @JsonProperty("user_id")
    private Integer id;
    private String name;
    private double distance;
    @JsonProperty("distance_unit")
    private String unit;
}
