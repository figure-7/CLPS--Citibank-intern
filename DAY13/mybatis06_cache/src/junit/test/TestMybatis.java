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

	//缓存有效
	@Test
	public void testGetCustomer() throws Exception{
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
		SqlSession session = sqlSessionFactory.openSession(); //SqlSession自带一级缓存		
		
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);

		Customer customer = mapper.getCustomer(1); //第一次,缓存没有,查询数据库,存放到缓存
		System.out.println(customer);
		System.out.println("2=================================2");
		customer = mapper.getCustomer(1); //第二次,缓存中存在,利用缓存.不用查询数据库了.
		System.out.println(customer);
		System.out.println("3=================================3");
		customer = mapper.getCustomer(1); //第二次,缓存中存在,利用缓存.不用查询数据库了.
		System.out.println(customer);
		
		session.commit();		
		session.close();
	}

	//缓存失效
	@Test
	public void testGetCustomer2() throws Exception{
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
		SqlSession session = sqlSessionFactory.openSession(); //SqlSession自带一级缓存		
		
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		/*	失败的一级缓存测试 
		[1]SQL语句或查询条件不同
		*/
//		Customer customer = mapper.getCustomer(1); 
//		System.out.println(customer);
//		System.out.println("=================================");
//		customer = mapper.getCustomer(2); 
//		System.out.println(customer);
		
		/*
		[2]分属不同SqlSession对象
		*/
		Customer customer = mapper.getCustomer(1); 
		System.out.println(customer);
		
		
		SqlSession session2 = sqlSessionFactory.openSession(); //SqlSession自带一级缓存		
		
		CustomerMapper mapper2 = session.getMapper(CustomerMapper.class);
		Customer customer2 = mapper2.getCustomer(1); 
		System.out.println(customer2);
		
		session.close(); //sqlSession关闭,缓存失效.
		session2.close();
		
		/*
		[3]查询前执行clearCache()
		*/
//		Customer customer = mapper.getCustomer(1); 
//		System.out.println(customer);
//		System.out.println("=================================");
//		
//		session.clearCache(); //clearCache()方法清理缓存所有数据.
//		
//		customer = mapper.getCustomer(1); 
//		System.out.println(customer);
		
		/*
		[4]提交事务*/
//		Customer customer = mapper.getCustomer(1); 
//		System.out.println(customer);
//		System.out.println("=================================");
//		
//		session.commit(); //执行事务提交会自动清理缓存		
//		
//		customer = mapper.getCustomer(1); 
//		System.out.println(customer);
//		
//		
//		session.close();
	}
	
	
	//不同的SqlSession间需要使用二级缓存.
	@Test
	public void testGetCustomer3() throws Exception{
		String resource = "mybatis-config.xml";		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		
		SqlSession session = sqlSessionFactory.openSession(); //SqlSession自带一级缓存			
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);

		Customer customer = mapper.getCustomer(1); //第一次,缓存没有,查询数据库,存放到缓存
		System.out.println(customer);
		
		session.commit();		
		session.close();
		
		
		System.out.println("=================================");
		
		
		SqlSession session2 = sqlSessionFactory.openSession(); //SqlSession自带一级缓存			
		CustomerMapper mapper2 = session2.getMapper(CustomerMapper.class);
		
		customer = mapper2.getCustomer(1); //第二次,缓存中存在,利用缓存.不用查询数据库了.
		System.out.println(customer);
		
		session2.commit();		
		session2.close();
	}


}
