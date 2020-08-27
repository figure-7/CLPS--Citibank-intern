package com.clps.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.clps.mybatis.bean.Customer;

public interface CustomerMapper {
	
	//实验0：保存Customer
	public int saveCustomer(Customer customer) throws Exception ;
	
	//实验1：删除cust_id为8的Customer
	public int deleteCustomer(Integer custId) throws Exception ;	
	
	//实验2：更新cust_id为10的Customer的姓名和年龄
	public int updateCustomer(Customer customer) throws Exception ;	
	
	//实验3：查询cust_id为12的Customer
	public Customer getCustomer(Integer custId) throws Exception ;
	
	//实验4：查询List<Customer>，没有查询条件
	public List<Customer> queryCustomerList() throws Exception ;
	
	//实验5：查询List<Customer>，查询条件是 (以实体类对象形式封装查询条件)
	// cust_name包含'a'
	// cust_age大于20
	public List<Customer> queryCustomerListByNameAndAge(Customer customer) throws Exception ;
	
	//实验6：查询List<Customer>，查询条件是 (以Map类型的对象封装查询条件)
	// cust_name包含'a'
	// order_amount大于20
	public List<Customer> queryCustomerListByMap(Map<String,Object> map) throws Exception ;
	
	//实验7：查询List<Customer>，查询条件是 (传多个零散的参数)
	// cust_age在25~30之间
	public List<Customer> queryCustomerListByAge(@Param("minAge") int minAge,@Param("maxAge") int maxAge) throws Exception ;
	
	// 实验8：查询order_id为5的cust_name和order_name (将零散的查询结果封装到Map对象中返回)
	public Map<String,Object> queryCustNameAndOrderName(int orderId);
	
	//实验9：查询order_amount大于20的cust_name和order_name
	public List<Map<String,Object>> queryCustNameAndOrderNameMap(double orderAmount);
	
	//实验10：查询cust_id为12的Customer，但是使用resultMap映射 (使用resultMap方式解决字段名与属性名不一致问题)
	public Customer getCustomerResultMap(Integer custId) throws Exception ;	
	
	//实验11：查询结果为单值，统计Customer数量
	public int countCustomer() throws Exception ;
	
	
	//实验12：执行DDL语句创建数据库表
	public void createTable(@Param("tableName")  String tableName) throws Exception ;
	public void createTable2(String tableName) throws Exception ;
	
}
