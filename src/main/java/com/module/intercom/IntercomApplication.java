package com.module.intercom;

import com.module.intercom.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Applicantion's entry point.
 *
 */
@SpringBootApplication
@Slf4j
public class IntercomApplication {

    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(IntercomApplication.class, args);
    }
}
