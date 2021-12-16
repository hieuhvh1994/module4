package com.repository;

import com.model.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> findAll();

    Customer add(Customer customer);

    Customer findById(int id);
}