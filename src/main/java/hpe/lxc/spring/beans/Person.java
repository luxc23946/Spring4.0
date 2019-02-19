package hpe.lxc.spring.beans;

public class Person {
	private String name;
	private Integer age;
	private Car car;
	
	public Person(){}
	
	public Person(String name, Integer age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
	
}
