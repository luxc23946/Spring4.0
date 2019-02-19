package hpe.lxc.spring.beans.collection;

import hpe.lxc.spring.beans.collection.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
	private String name;
	private Integer age;
	private String[] hobbies;
	private List<Car> cars;
	private Set<String> hates;
	private Map<String, Car> carMap;
	
	public Person(){}
	
	public Person(String name, Integer age, Car car) {
		this.name = name;
		this.age = age;
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
	
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void setHates(Set<String> hates) {
		this.hates = hates;
	}
	public Set<String> getHates() {
		return hates;
	}
	

	public Map<String, Car> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<String, Car> carMap) {
		this.carMap = carMap;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "\n, hobbies="
				+""+ Arrays.toString(hobbies) + ", cars=" + cars + "\n, hates="
				+ hates + "\n, carMap=" + carMap + "]";
	}

	
	
}
