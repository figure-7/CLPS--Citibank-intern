package junit.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.clps.mybatis.bean.Customer;
import com.clps.mybatis.mapper.CustomerMapper;

public class TestMybatis {

	@Test
	public void testSaveCustomer() throws Exception {
		//创建SqlSessionFactory对象
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		
		//创建Mapper对象,即DAO对象
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		System.out.println(mapper.getClass().getName());
		
		//准备数据
		Customer customer = new Customer(null,"zhangsan20200826",27);
		
		//保存数据
		mapper.saveCustomer(customer);
		
		//提交事务
		session.commit();
		
		//关闭对象
		session.close();
	}

}
