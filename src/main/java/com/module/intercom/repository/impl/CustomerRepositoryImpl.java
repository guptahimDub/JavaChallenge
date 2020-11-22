package com.module.intercom.repository.impl;

import com.module.intercom.model.Customer;
import com.module.intercom.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository responsible for manipulating the Customer object.
 */
@Slf4j
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Convert a string in JSON format to a Customer entity.
     *
     * @param line in JSON format.
     * @return a customer.
     */
    private static Customer convertJsonFileToCustomers(String line) {
        try {
            return MAPPER.readValue(line, Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Fetch all the customers from the file JSON file customers.txt
     *
     * @return a list of customers.
     */
    @Override
    public List<Customer> findCustomers() {
        List<Customer> customers = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("customers.txt");
        Path path;
        try {
            path = Paths.get(url.toURI());
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                customers.add(convertJsonFileToCustomers(line));
            }
            return customers;
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;


    }

}