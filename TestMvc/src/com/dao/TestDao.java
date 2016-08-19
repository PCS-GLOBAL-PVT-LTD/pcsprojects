package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.model.TestModel;

public class TestDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(TestModel obj) {
		System.out.println("name " + obj.getName());
		System.out.println("age " + obj.getAge());
		String sql = "insert into test (name,age) values('" + obj.getName() + "','" + obj.getAge() + "')";
		int status = jdbcTemplate.update(sql);

		return status;
	}

	public int delete(int id) {
		String sql = "delete from test  where id ='" + id + "'";
		int status = jdbcTemplate.update(sql);
		return status;
	}

	public int update(TestModel obj2) {
		String sql = "update test set name = '" + obj2.getName() + "',age='" + obj2.getAge() + "'where id='"
				+ obj2.getId() + "'";
		int status = jdbcTemplate.update(sql);
		return status;
	}

	public TestModel getemp(int id){
		String sql="select * from test where id='"+id+"'";
		TestModel testModel=(TestModel) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(TestModel.class));
		
		return testModel;
	}
	public List<TestModel> showall() {
		String sql = "select * from test";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<TestModel>>() {

			@Override
			public List<TestModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<TestModel> empList = new ArrayList<TestModel>();
				while (rs.next()) {
					TestModel store = new TestModel();
					store.setId(rs.getInt("id"));
					store.setName(rs.getString("name"));
					store.setAge(rs.getInt("age"));
					empList.add(store);
				}
				return empList;
			}
		});
	}
	
	/*public List<TestModel> printEmp(){
		
		String sql="select * from test";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<TestModel>>(){

			@Override
			public List<TestModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<TestModel> empArrList=new ArrayList<TestModel>();
				while (rs.next()) {
					TestModel store=new TestModel();
					store.setId(rs.getInt("id"));
					store.setName(rs.getString("name"));
					store.setAge(rs.getInt("age"));
					empArrList.add(store);
					
				}
				return empArrList;
			}
			
		});
		
	}
	*/
	
}
