package junit.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//=======简单的增删改查:实验0~5========================================================
	
	//  实验0：保存Customer
	@Test
	public void testSaveCustomer() throws Exception {
		Customer customer = new Customer(null,"田七5",22);
		int i = mapper.saveCustomer(customer);
		System.out.println(i);
		
		System.out.println("custId="+customer.getCustId());
	}
	
	
	// 实验1：删除cust_id为8的Customer
	@Test
	public void testDeleteCustomer() throws Exception{
		int i = mapper.deleteCustomer(10);
		System.out.println("i="+i);
	}
	
	
	// 实验2：更新cust_id为10的Customer的姓名和年龄
	@Test
	public void testUpdateCustomer() throws Exception{
		Customer customer = new Customer(0,"lisinew",24);
		int i = mapper.updateCustomer(customer);
		System.out.println("i="+i);
	}
	
	// 实验3：查询cust_id为12的Customer
	@Test
	public void testGetCustomer() throws Exception{
		Customer customer = mapper.getCustomer(1);
		System.out.println(customer);
	}
	
	// 实验4：查询List<Customer>，没有查询条件
	@Test
	public void testQueryCustomer() throws Exception{
		List<Customer> list = mapper.queryCustomerList();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	//===============================================================
	
	//=======测试不同的查询条件参数传递方式:===============================
	
	// 实验5：查询List<Customer>，查询条件是 (以实体类对象形式封装查询条件)
	// cust_name包含'l'
	// cust_age大于20
	@Test
	public void testQueryCustomerListByNameAndAge() throws Exception{
		String name = "l";
		Customer customer = new Customer();
		customer.setCustName("%"+name+"%");
		customer.setCustAge(20);
		
		List<Customer> list = mapper.queryCustomerListByNameAndAge(customer);
		for (Customer c : list) {
			System.out.println(c);
		}
	}
	
	@Test
	public void testQueryCustomerListByNameAndAgeMap() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("custName", "%l%");
		map.put("custAge", 20);
		
		List<Customer> list = mapper.queryCustomerListByNameAndAgeMap(map);
		for (Customer c : list) {
			System.out.println(c);
		}
	}
	
	
	// 实验6：查询List<Customer>，查询条件是 (以Map类型的对象封装查询条件)
	// cust_name包含'a'
	// order_amount大于20
	@Test
	public void testQueryCustomerListByMap() throws Exception{

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("custName", "%a%");
		map.put("orderAmount", 20);
		
		List<Customer> list = mapper.queryCustomerListByMap(map);
		for (Customer c : list) {
			System.out.println(c);
		}
	}	
	
	
	// 实验7：查询List<Customer>，查询条件是 (传多个零散的参数)
	// cust_age在25~30之间
	@Test
	public void testQueryCustomerListByAge() throws Exception{		
		List<Customer> list = mapper.queryCustomerListByAge(27, 30);
		for (Customer c : list) {
			System.out.println(c);
		}
	}		
	


	//=======测试不同的返回结果方式:===============================	
	
	// 实验8：查询order_id为5的cust_name和order_name (将零散的查询结果封装到Map对象中返回)
	@Test
	public void testQueryCustNameAndOrderName() throws Exception{		
		Map<String,Object> map = mapper.queryCustNameAndOrderName(5);
		System.out.println(map);
	}	
	
	
	
	// 实验9：查询order_amount大于20的cust_name和order_name
	// (查询结果的一条记录对应一个Map对象,多条记录的结果可以使用List封装Map对象)
	@Test
	public void testQueryCustNameAndOrderNameMap() throws Exception{		
		List<Map<String,Object>> list = mapper.queryCustNameAndOrderNameMap(20);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}	
	
	// 实验10：查询cust_id为12的Customer，但是使用resultMap映射 (使用resultMap方式解决字段名与属性名不一致问题)
	@Test
	public void testGetCustomerResultMap() throws Exception{		
		Customer c = mapper.getCustomerResultMap(1);
		System.out.println(c);
	}

	// 实验11：查询结果为单值，统计Customer数量
	@Test
	public void testCountCustomer() throws Exception{		
		int countCustomer = mapper.countCustomer();
		System.out.println(countCustomer);
	}

	// 实验12：执行DDL语句创建数据库表
	@Test
	public void testCreateTable() throws Exception{		
		mapper.createTable("tbl_cust2");
	}
	@Test
	public void testCreateTable2() throws Exception{		
		mapper.createTable("tbl_cust3");
	}
	

}
