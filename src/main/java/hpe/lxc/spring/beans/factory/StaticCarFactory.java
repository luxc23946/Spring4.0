package hpe.lxc.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法:通过调用某一个类的静态方法就可以返回Bean的实例
 * @author Administrator
 *
 */
public class StaticCarFactory {
	private static Map<String, Car> cars=new HashMap<String, Car>();
	static{
		cars.put("audi", new Car("audi",300000d));
		cars.put("ford", new Car("ford", 400000d));
	}
	
	/**
	 * 静态工厂方法
	 * @param name
	 * @return
	 */
	public static Car getCar(String name){
		return cars.get(name);
	}
}
