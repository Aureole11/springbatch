package com.batch.db2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.db2db.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
