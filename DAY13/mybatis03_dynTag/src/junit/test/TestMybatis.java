package junit.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.mybatis.bean.Customer;
import com.clps.mybatis.mapper.CustomerMapper;

public class TestMybatis {
	private SqlSession session;
	private CustomerMapper mapper  ;
	
	//在每一个测试方法前执行
	@Before
	public void setUp() throws Exception{
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
		session = sqlSessionFactory.openSession();		
		mapper = session.getMapper(CustomerMapper.class);
		System.out.println(mapper.getClass().getName());
	}
	
	//在每一个测试方法后执行
	@After
	public void tearDown(){
		session.commit();		
		session.close();
	}

	@Test
	public void test1() throws Exception {
		List<Customer> list = mapper.getListByMinMaxAge(20, 25);
		for (Customer customer : list) {
			System.out.println(customer);			
		}
	}
	
//	@Test
//	public void test1when() throws Exception {
//		List<Customer> list = mapper.getListByMinMaxAge(20, 25);
//		for (Customer customer : list) {
//			System.out.println(customer);			
//		}
//	}
	
	@Test
	public void test2() throws Exception {
//		List<Customer> list = mapper.getListBySeveralIds(Arrays.asList(1,3,6,5));
		List<Customer> list = mapper.getListBySeveralIds(new ArrayList<>());
		for (Customer customer : list) {
			System.out.println(customer);			
		}
	}
	
	@Test
	public void test3() throws Exception {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(null,"aaa",22));
		list.add(new Customer(null,"bbb",23));
		list.add(new Customer(null,"ccc",24));
		
		mapper.batchSaveCustomer(list);
	}
	
	@Test
	public void test4() throws Exception {
		Customer customer = new Customer(null,"BB",null);		
		mapper.saveCustomerClever(customer);
	}
	
	@Test
	public void test5() throws Exception {
		Customer customer = new Customer(1,"CC",null);		
		mapper.updateCustomer(customer);
	}
	
}
