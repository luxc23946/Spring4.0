package hpe.lxc.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	public Employee getEmployeeById(String id){
		Employee employee=null;
		String sql="select id,last_name lastName,email from employees where id=?";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		
		employee=jdbcTemplate.queryForObject(sql,rowMapper,id);
		return employee;
	}
	
	
}
