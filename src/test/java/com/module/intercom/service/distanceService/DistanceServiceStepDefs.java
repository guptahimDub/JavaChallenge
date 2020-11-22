package com.module.intercom.service.distanceService;

import com.module.intercom.AppConfiguration;
import com.module.intercom.model.Customer;
import com.module.intercom.model.enums.DistanceUnitEnum;
import com.module.intercom.service.impl.DistanceServiceImpl;
import com.module.intercom.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Behavior Driven Step Definions to test if users are within a distance.
 */

@Slf4j
@ContextConfiguration(classes = {AppConfiguration.class})
public class DistanceServiceStepDefs {

    Customer.CustomerBuilder builder;

    @Autowired
    DistanceServiceImpl distanceService;

    private double distanceInKm;

    @Before
    public void before() {
        builder = Customer.builder();
    }

    @Given("^a user with with id \"([^\"]*)\"$")
    public void aUserWithWithId(String id) {
        builder.id(Integer.valueOf(id));
    }

    @And("^his name is \"([^\"]*)\"$")
    public void hisNameIs(String name) {
        builder.name(name);
    }

    @And("^his latitude is \"([^\"]*)\"$")
    public void hisLatitudeIs(String latitude) {
        builder.latitude(Double.valueOf(latitude));
    }

    @And("^his is longitude \"([^\"]*)\"$")
    public void hisIsLongitude(String longitude) {
        builder.longitude(Double.valueOf(longitude));
    }

    @When("^calculated the user distance to intercom dublin office$")
    public void calculatedTheUserDistanceToIntercomDublinOffice() {
        Customer customer = builder.build();
        distanceInKm = distanceService.calculateDistance(
                Constants.DUBLIN_OFFICE_LATITUDE,
                Constants.DUBLIN_OFFICE_LONGITUDE,
                customer.getLatitude(),
                customer.getLongitude(),
                DistanceUnitEnum.KM);
        log.info(String.format("Distance calculated: %s", distanceInKm));
    }

    @Then("^it should be less or equal (\\d+) km distance from intercom dublin office$")
    public void itShouldBeUnderKmDistanceFromIntercomDublinOffice(int distance) {
        Assert.assertTrue(distanceInKm <= distance);
    }

    @Then("^it should be greater then (\\d+) km distance from intercom dublin office$")
    public void itShouldBeGreaterThenKmDistanceFromIntercomDublinOffice(int distance) {
        Assert.assertTrue(distanceInKm > distance);
    }
}
