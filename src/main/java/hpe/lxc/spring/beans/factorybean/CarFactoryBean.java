package hpe.lxc.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义FactoryBean需要实现FactoryBean接口
 * @author Administrator
 *
 */
public class CarFactoryBean implements FactoryBean<Car> {
	
	private String brand;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	/**
	 * 返回bean的对象
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car(brand, 500000D);
	}

	/**
	 * 返回bean的类型
	 */
	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	/**
	 * 该bean是否是单实例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
