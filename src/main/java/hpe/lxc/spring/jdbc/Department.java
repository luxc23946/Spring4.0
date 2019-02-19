package hpe.lxc.spring.jdbc;

public class Department {
	
	private Integer dept_id;
	private String dept_name;
	
	
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name
				+ "]";
	}
	
	
	
}
