package hpe.lxc.spring.beans;

public class Car {

	private String name;
	private Float price;
	private Integer speed;
	
	public Car() {}
	
	public Car(String name, Float price) {
		this.name = name;
		this.price = price;
		System.out.println("Car's Constructor [String ,float ]");
	}
	
	public Car(String name, Integer speed) {
		this.name = name;
		this.speed = speed;
		System.out.println("Car's Constructor [String ,Integer ]");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getspeed() {
		return speed;
	}
	public void setspeed(Integer speed) {
		this.speed = speed;
	}
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", speed=" + speed
				+ "]";
	}
	
	
	
}
