package com.module.intercom.repository;

import com.module.intercom.model.Customer;
import com.module.intercom.repository.impl.CustomerRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

@Slf4j
public class CustomerRepositoryTest {

    CustomerRepository customerRepository;

    @Before
    public void setup(){
        customerRepository = new CustomerRepositoryImpl();
    }

    @Test
    public void getCustomersFromFile() {
        List<Customer> customers = customerRepository.findCustomers();
        Assert.assertNotNull(customers);
        Assert.assertFalse(customers.isEmpty());
        for (Customer customer : customers) {
            Assert.assertNotNull(customer.getId());
            Assert.assertNotNull(customer.getLatitude());
            Assert.assertNotNull(customer.getLongitude());
            Assert.assertNotNull(customer.getName());
        }
    }
}
