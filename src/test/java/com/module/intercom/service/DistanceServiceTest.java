package com.module.intercom.service;

import com.module.intercom.model.enums.DistanceUnitEnum;
import com.module.intercom.service.impl.DistanceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
public class DistanceServiceTest {

    private static final double LATITUDE_1 = 32.9697;
    private static final double LONGITUDE_1 = -96.80322;
    private static final double LATITUDE_2 = 29.46786;
    private static final double LONGITUDE_2 = -98.53506;

    @Autowired
    DistanceServiceImpl distanceService;

    @Test
    public void calculateDistance() {
        double miles = distanceService.calculateDistance(
                LATITUDE_1,
                LONGITUDE_1,
                LATITUDE_2,
                LONGITUDE_2,
                DistanceUnitEnum.MILES);
        log.info(String.format("%s Miles", miles));
        Assert.assertEquals(262.6777938054349, miles, 4);

        double km = distanceService.calculateDistance(
                LATITUDE_1,
                LONGITUDE_1,
                LATITUDE_2,
                LONGITUDE_2,
                DistanceUnitEnum.KM);
        log.info(String.format("%s Kilometers", km));
        Assert.assertEquals(422.73893139401383, km, 4);

        double nauticalMiles = distanceService.calculateDistance(
                LATITUDE_1,
                LONGITUDE_1,
                LATITUDE_2,
                LONGITUDE_2,
                DistanceUnitEnum.NAUTICAL_MILES);
        log.info(String.format("%s Nautica lMiles", nauticalMiles));
        Assert.assertEquals(228.10939614063963, nauticalMiles, 4);

    }

    @TestConfiguration
    static class DistanceServiceTestConfiguration {
        @Bean
        public DistanceServiceImpl distanceService() {
            return new DistanceServiceImpl();
        }
    }

}
