package junit.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.clps.mybatis.bean.Customer;
import com.clps.mybatis.mapper.CustomerAnnoMapper;

public class TestAnnotation {
	// 实验：通过注解版Mapper接口查询cust_id为12的Customer
	@Test
	public void test14() throws IOException {	
		
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
		SqlSession session = sqlSessionFactory.openSession();	
		
		Customer cust = new Customer(null,"b",22);
		
		CustomerAnnoMapper mapper = session.getMapper(CustomerAnnoMapper.class);
		mapper.saveCustomer(cust);
		
		session.commit();
		
		session.close();
	}

}
