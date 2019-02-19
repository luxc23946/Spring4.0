package hpe.lxc.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬��������:ͨ������ĳһ����ľ�̬�����Ϳ��Է���Bean��ʵ��
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
	 * ��̬��������
	 * @param name
	 * @return
	 */
	public static Car getCar(String name){
		return cars.get(name);
	}
}
