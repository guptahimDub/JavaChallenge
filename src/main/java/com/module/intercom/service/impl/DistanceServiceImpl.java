package com.module.intercom.service.impl;

import com.module.intercom.model.Customer;
import com.module.intercom.model.enums.DistanceUnitEnum;
import com.module.intercom.service.DistanceService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class DistanceServiceImpl implements DistanceService {

    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2, DistanceUnitEnum unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit != null && unit.equals(DistanceUnitEnum.KM)) {
                dist = dist * 1.609344;
            } else if (unit != null && unit.equals(DistanceUnitEnum.NAUTICAL_MILES)) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

    @Override
    public double calculateDistance(double lat1, double lon1, Customer customer, DistanceUnitEnum unit) {
        double dist = calculateDistance(
                lat1,
                lon1,
                customer.getLatitude(),
                customer.getLongitude(),
                unit);
        customer.setDistance(dist);
        customer.setDistanceUnit(unit);
        log.info(String.format("%s -> Calculated Distance: %.4f", customer.toString(), dist));
        return dist;
    }

}
