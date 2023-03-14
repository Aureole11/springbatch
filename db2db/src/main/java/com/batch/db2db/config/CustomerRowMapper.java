package com.batch.db2db.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.batch.db2db.model.Test;


public class CustomerRowMapper implements RowMapper<Test>{
	

	   public Test mapRow(ResultSet rs, int i) throws SQLException {

		   Test test = new Test();
			   test.setAge(rs.getString("age"));
			   test.setCustomer_id(rs.getInt("customer_id"));
			   test.setFirstname(rs.getString("first_name"));
			   test.setLastname(rs.getString("last_name"));
		   
		   return test;
	   }
}
