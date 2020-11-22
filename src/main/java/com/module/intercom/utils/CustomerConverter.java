package com.module.intercom.utils;

import com.module.intercom.dao.CustomerDao;
import com.module.intercom.model.Customer;

public class CustomerConverter {

    public static Customer dtoToEntity(CustomerDao customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();
    }

    public static CustomerDao entityToDto(Customer customer) {
        return CustomerDao.builder()
                .id(customer.getId())
                .name(customer.getName())
                .distance(customer.getDistance())
                .unit(customer.getDistanceUnit().toString())
                .build();
    }
}
