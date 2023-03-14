package com.batch.db2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.db2db.model.Customer;
import com.batch.db2db.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{

	void save(Customer c);

}
