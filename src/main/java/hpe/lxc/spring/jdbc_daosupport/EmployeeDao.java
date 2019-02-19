package hpe.lxc.spring.jdbc_daosupport;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class EmployeeDao extends JdbcDaoSupport {
	
	public Employee getEmployeeById(String id){
		Employee employee=null;
		String sql="select id,last_name lastName,email from employees where id=?";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		
		employee=super.getJdbcTemplate().queryForObject(sql,rowMapper,id);
		return employee;
	}
	
	
}
