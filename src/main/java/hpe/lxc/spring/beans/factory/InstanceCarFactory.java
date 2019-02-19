package hpe.lxc.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;
/**
 * ʵ����������:��Ҫ�ȴ������������ٵ��ù�����ʵ������������bean��ʵ��
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
