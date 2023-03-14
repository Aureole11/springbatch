//package com.batch.db2db.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.batch.db2db.model.Customer;
//import com.batch.db2db.model.Test;
//import com.batch.db2db.repository.CustomerRepository;
//import com.batch.db2db.repository.TestRepository;
//
//@Service
//public class TestService {
//
//	@Autowired
//	private CustomerRepository customerRepo;
//	@Autowired
//	private TestRepository testRepo;
//
//	
//	public List<Customer> getAll(){
//		List<Customer> cust=customerRepo.findAll();
//		System.out.println(cust);
//		for(Customer c:cust) {
//			System.out.println("Data to insert :------"+ c);
//			Test test = new Test();
//			test.setAge(c.getAge());
//			test.setCustomer_id(c.getCustomer_id());
//			test.setFirstname(c.getFirstname());
//			test.setLastname(c.getLastname());
//			
//			testRepo.save(test);
//		}
//		return cust;
//	}
//}
