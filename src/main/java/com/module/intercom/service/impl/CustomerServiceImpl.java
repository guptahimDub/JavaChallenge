package com.module.intercom.service.impl;

import com.module.intercom.dao.CustomerDao;
import com.module.intercom.model.Customer;
import com.module.intercom.model.enums.DistanceUnitEnum;
import com.module.intercom.repository.CustomerRepository;
import com.module.intercom.service.CustomerService;
import com.module.intercom.utils.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.module.intercom.utils.Constants.DUBLIN_OFFICE_LATITUDE;
import static com.module.intercom.utils.Constants.DUBLIN_OFFICE_LONGITUDE;

/**
 * Services related to Customer entity.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DistanceServiceImpl distanceService;

    public List<CustomerDao> findCustomerWithinDistance(List<Customer> customers,
                                                        double distance,
                                                        DistanceUnitEnum unit) {
        return customers
                .stream()
                .filter(c -> isCustumerWithinDistanceRangeClosed(c, unit, distance))
                .sorted()
                .map(CustomerConverter::entityToDto)
                .collect(Collectors.toList());
    }


    public List<Customer> findCustomers() {
        return customerRepository
                .findCustomers()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Check if a customer's geo location is within the give distance range.
     *
     * @param customer whose geo location is desired to be compared
     * @param unit     used to calculate the distance
     * @param distance to be compared with
     * @return true if the customer's geo location is smaller or equal then the distance compared
     */
    private boolean isCustumerWithinDistanceRangeClosed(Customer customer, DistanceUnitEnum unit, double distance) {
        double customerDistance = distanceService
                .calculateDistance(
                        DUBLIN_OFFICE_LATITUDE,
                        DUBLIN_OFFICE_LONGITUDE,
                        customer,
                        unit);
        return customerDistance <= distance;

    }

}
