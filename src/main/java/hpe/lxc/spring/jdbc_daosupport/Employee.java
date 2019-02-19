package hpe.lxc.spring.jdbc_daosupport;

public class Employee {
	
	private Integer id;
	private String lastName;
	private String email;
	private int deptId;
	
	public Employee() {}

	
	public Employee(Integer id, String lastName, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", deptId=" + deptId + "]";
	}
	
}
