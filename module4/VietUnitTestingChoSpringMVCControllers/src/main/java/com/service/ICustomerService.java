package com.service;

import com.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer add(Customer customer);

    Customer findById(int id);
}
