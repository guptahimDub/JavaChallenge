package com.module.intercom.controller;


import com.module.intercom.dao.CustomerDao;
import com.module.intercom.model.Customer;
import com.module.intercom.model.enums.DistanceUnitEnum;
import com.module.intercom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that controls de APIs related to customers
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> findCustomers() {
        return customerService.findCustomers();
    }

    @RequestMapping("/customers/{distance}")
    public List<CustomerDao> findCustomersWithinDistance(@PathVariable(value = "distance") String distance) {
        List<Customer> customers = customerService.findCustomers();
        return customerService.findCustomerWithinDistance(
                customers,
                Double.valueOf(distance),
                DistanceUnitEnum.KM);
    }

}
