package com.module.intercom.service.distanceService;

import com.module.intercom.AppConfiguration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/module/intercom/service/distanceService.feature",
        plugin = {"pretty", "html:target/cucumber/distanceService"}
)
public class DistanceServiceImplSpecTest {
}
