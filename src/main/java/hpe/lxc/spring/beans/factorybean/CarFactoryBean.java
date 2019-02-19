package hpe.lxc.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * �Զ���FactoryBean��Ҫʵ��FactoryBean�ӿ�
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
	 * ����bean�Ķ���
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car(brand, 500000D);
	}

	/**
	 * ����bean������
	 */
	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	/**
	 * ��bean�Ƿ��ǵ�ʵ��
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
