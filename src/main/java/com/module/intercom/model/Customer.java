package com.module.intercom.model;

import com.module.intercom.model.enums.DistanceUnitEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Transient;

/**
 * Classe representing the customer's data model.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Customer implements Comparable<Customer> {

    @JsonProperty("user_id")
    private Integer id;
    private String name;
    private double latitude;
    private double longitude;
    @Transient
    private double distance;
    @JsonProperty("distance_unit")
    @Transient
    private DistanceUnitEnum distanceUnit;

    /**
     * Sort function which compares the current customer instance with a given object.
     *
     * @param o object to be compared.
     * @return return an int representing the order of the object in relation with the compared object.
     */
    @Override
    public int compareTo(Customer o) {
        if (this.id < o.getId()) {
            return -1;
        } else if (this.id > o.getId()) {
            return 1;
        }
        return 0;
    }
}