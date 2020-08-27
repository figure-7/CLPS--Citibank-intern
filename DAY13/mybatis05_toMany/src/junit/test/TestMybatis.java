package junit.test;

import java.io.InputStream;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.mybatis.bean.Customer;
import com.clps.mybatis.bean.Order;
import com.clps.mybatis.mapper.CustomerMapper;
import com.clps.mybatis.mapper.OrderMapper;

public class TestMybatis {
	private SqlSession session;
	
	
	//在每一个测试方法前执行
	@Before
	public void setUp() throws Exception{
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
		session = sqlSessionFactory.openSession();		
		
	}
	
	//在每一个测试方法后执行
	@After
	public void tearDown(){
		session.commit();		
		session.close();
	}

	
	@Test
	public void test1() throws Exception {
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomerByCustId(1);
		System.out.println(customer.getCustName());

	}
	
	
	@Test
	public void test2() throws Exception {
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomerByCustId(1);

		//class com.atguigu.mybatis.bean.Customer$$EnhancerByCGLIB$$132c79cb
		System.out.println(customer.getClass().getName());
		System.out.println(customer.getCustName());
		
//		Set<Order> orderSet = customer.getOrderSet();
//		System.out.println(orderSet.getClass());
//		for (Order order : orderSet) {
//			System.out.println(order.getClass());
//			System.out.println(order.getOrderName());
//		}

	}
	
	@Test
	public void testOrderMapper() throws Exception {
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		Set<Order> customer = mapper.getOrderByCustId(1);
		for (Order order : customer) {
			System.out.println(order);
		}

	}
}
