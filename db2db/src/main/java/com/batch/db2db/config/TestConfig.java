package com.batch.db2db.config;


//import java.util.HashMap;
//import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.AbstractCursorItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.batch.db2db.model.Test;
import com.batch.db2db.repository.TestRepository;

@Configuration
@EnableBatchProcessing
public class TestConfig {

	
	private JobBuilderFactory jobBuilder;
	
	private StepBuilderFactory stepBuilder;
	
	@Autowired
	private TestRepository testRepository;

	public TestConfig(JobBuilderFactory jobBuilder, StepBuilderFactory stepBuilder) {
		super();
		this.jobBuilder = jobBuilder;
		this.stepBuilder = stepBuilder;
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public ItemReader<Test> reader(){
		ItemReader<Test> reader = new JdbcCursorItemReader<>();
		((JdbcCursorItemReader<Test>) reader).setSql("SELECT customer_id, first_name, last_name, age FROM customer_info");
		((AbstractCursorItemReader<Test>) reader).setDataSource(dataSource);
		((AbstractCursorItemReader<Test>) reader).setFetchSize(100);
		((JdbcCursorItemReader<Test>) reader).setRowMapper((RowMapper<Test>) new CustomerRowMapper());
		
		return reader;
	}
	
//	@Bean
//	public JdbcPagingItemReader<Test> pagingItemReader(){
//		JdbcPagingItemReader<Test> reader = new JdbcPagingItemReader<>();
//		reader.setDataSource(this.dataSource);
//		reader.setFetchSize(10);
//		reader.setRowMapper((RowMapper<Test>) new CustomerRowMapper());
//		
//		Map<String, Order> sortKeys = new HashMap<>();
//		sortKeys.put("customer_id", Order.ASCENDING);
//		
//		MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
//		queryProvider.setSelectClause("select customer_id, first_name, last_name, age");
//		queryProvider.setFromClause("from customer_info");
//		queryProvider.setSortKeys(sortKeys);
//		reader.setQueryProvider(queryProvider);
//		
//		return reader;
//	}
//	

@Bean
public TestProcessor processor() {
	return new TestProcessor();
}

@Bean
public ItemWriter<Test> writer(){
	RepositoryItemWriter<Test> writer=new RepositoryItemWriter<>();
	writer.setRepository(testRepository);
	writer.setMethodName("save");
	return writer;
}


@Bean
public Step step1() {
	return stepBuilder.get("data").<Test, Test>chunk(100)
			.reader(reader())
//			.reader(pagingItemReader())
			.processor((ItemProcessor<? super Test, ? extends Test>) processor())
			.writer(writer())
			.build();
}

@Bean	
public Job runJob() {
	return jobBuilder.get("import Test")
			.flow(step1()).end().build();
}
	
}
