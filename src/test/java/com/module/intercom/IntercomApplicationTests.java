package com.module.intercom;

import com.module.intercom.controller.CustomerController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IntercomApplicationTests {

    @Autowired
    CustomerController customerController;

    @Test
    public void contextLoads() {
        log.info("Executing metodo findCustomersWithinDistance");
        log.info(customerController.findCustomersWithinDistance("11").toString());
        log.info("End of execution of method findCustomersWithinDistance");
    }

}
