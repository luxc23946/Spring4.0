package hpe.lxc.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;
/**
 * 实例工厂方法:需要先创建工厂本身再调用工厂的实例方法来返回bean的实例
 * @author Administrator
 *
 */
public class InstanceCarFactory {
	private Map<String, Car> cars=null;
	
	public InstanceCarFactory(){
		cars=new HashMap<String, Car>();
		cars.put("audi", new Car("audi",300000d));
		cars.put("ford", new Car("ford",400000d));
	}
	
	public Car getCar(String name){
		return cars.get(name);
	}
}
