package hpe.lxc.spring.jdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


public class Main {
	
	private ApplicationContext actx=null;
	private JdbcTemplate jdbcTemplate=null;
	EmployeeDao employeeDao=null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate=null;
	
	@Before
	public void init(){
		actx=new ClassPathXmlApplicationContext("hpe/lxc/spring/jdbc/applicationContext-springJDBC.xml");
		jdbcTemplate=(JdbcTemplate) actx.getBean("jdbcTemplate");
		employeeDao=(EmployeeDao) actx.getBean("employeeDao");
		namedParameterJdbcTemplate=(NamedParameterJdbcTemplate) actx.getBean("namedParameterJdbcTemplate");
	}
	
	
	@Test
	public void testConnection() throws SQLException {
		DataSource dataSource=(DataSource) actx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testInsert(){
		String sql="insert into employees(last_name,email) VALUES(?,?)";
		int count=jdbcTemplate.update(sql,"lxc","123@qq.com");
		System.out.println(count);
	}
	
	@Test
	public void testUpdate(){
		String sql="update employees set email=? where last_name=?";
		int count=jdbcTemplate.update(sql,"123@qq.com","lxc");
		System.out.println(count);
	}
	
	@Test
	public void testDelete(){
		String sql="delete from employees where last_name=?";
		int count=jdbcTemplate.update(sql,"lxc");
		System.out.println(count);
	}
	
	/**
	 * ִ����������
	 */
	@Test
	public void testBatchUpdate(){
		String sql="insert into employees(last_name,email,dept_id) VALUES(?,?,?)";
		List<Object[]> batchArgs=new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"AAA","aaa@123.com",1});
		batchArgs.add(new Object[]{"BBB","bbb@123.com",1});
		batchArgs.add(new Object[]{"CCC","ccc@123.com",1});
		
		int[] count =jdbcTemplate.batchUpdate(sql, batchArgs);
		System.out.println(Arrays.asList(count));
	}
	
	/**
	 * �����ݿ��л�ȡһ����¼,ʵ���ϵõ�һ������
	 * ��֧�ּ������Ե�ӳ��
	 */
	@Test
	public void testQueryForObject(){
		String sql="select id,last_name lastName,email from employees where id=?";
		
		/*
		RowMapper<Employee> rowMapper=new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				Employee employees=new Employee();

					employees.setId(arg0.getInt(1));
					employees.setlastName(arg0.getString(2));
					employees.setEmail(arg0.getString(3));
				return employees;
			}
		};
		*/
		
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee=jdbcTemplate.queryForObject(sql,rowMapper,1);
		System.out.println(employee);
	}
	
	
	/**
	 * ��ѯʵ����ļ���
	 */
	@Test
	public void testQueryForList(){
		
		String sql="select id,last_name lastName,email from employees where id>?";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> employees=jdbcTemplate.query(sql, rowMapper,1);
		System.out.println(employees);
		
	}
	
	/**
	 * ��ȡ�����е�ֵ�����ͳ�Ʋ�ѯ
	 */
	@Test
	public void testQueryForObject2(){
		String sql="select count(id) from employees where id>?";
		long count =jdbcTemplate.queryForObject(sql, Long.class,3);
		System.out.println(count);
	}
	
	
	/**
	 * ���Կ�������
	 */
	@Test
	public void testEmployeeDao(){
		Employee employee=employeeDao.getEmployeeById("2");
		System.out.println(employee);
	}
	
	/**
	 * ����Ϊ����������.
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql="insert into employees(last_name,email,dept_id) values(:last_name,:email,:dept_id)";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("last_name", "xxx");
		paramMap.put("email", "xxx@123.com");
		paramMap.put("dept_id", "2");
		
		int count =namedParameterJdbcTemplate.update(sql, paramMap);
		System.out.println(count);
	}
	
	@Test
	public void testSqlParameterSource(){
		String sql="insert into employees(last_name,email,dept_id) values(:lastName,:email,:deptId)";
		Employee employee=new Employee();
		employee.setDeptId(2);
		employee.setEmail("xyz@123.com");
		employee.setlastName("xyz");
		SqlParameterSource sqlParameterSource=new BeanPropertySqlParameterSource(employee);
		int count =namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		System.out.println(count);
	}
	
}



