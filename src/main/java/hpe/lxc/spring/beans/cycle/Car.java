package hpe.lxc.spring.beans.cycle;

public class Car {
	private String brand;
	
	public Car() {
		System.out.println("Car's constructor");
	}
	
	
	public Car(String brand) {
		super();
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}
	 
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	public void init(){
		System.out.println("Car's init");
	}
	public void destory(){
		System.out.println("Car's destory");
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand+"]";}
	
	
}
