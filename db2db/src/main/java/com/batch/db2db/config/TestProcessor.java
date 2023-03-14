package com.batch.db2db.config;

import org.springframework.batch.item.ItemProcessor;

import com.batch.db2db.model.Test;


public class TestProcessor implements ItemProcessor<Test, Test> {
	public Test process(Test test) throws Exception {
//		if(customer.getAge().equals("30")) {
		return test;
//	}
//		else {
//			return null;
//		}
	}

}
