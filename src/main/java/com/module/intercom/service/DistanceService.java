package com.module.intercom.service;

import com.module.intercom.model.Customer;
import com.module.intercom.model.enums.DistanceUnitEnum;

/**
 * Interface with methods related to distance.
 */
public interface DistanceService {

    /**
     * Calculate the distance between two given points.
     *
     * @param lat1 latitude of the first point.
     * @param lon1 longitude of the first point.
     * @param lat2 latitude of the second point.
     * @param lon2 latitude of the second point.
     * @param unit in which the distance should be measured.
     * @return the distance between the two given points based on the passed unit.
     */
    double calculateDistance(double lat1, double lon1, double lat2, double lon2, DistanceUnitEnum unit);

    double calculateDistance(double lat1, double lon1, Customer customer, DistanceUnitEnum unit);
}
