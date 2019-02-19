package hpe.lxc.spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/factory/applicationContext-factory.xml");
		Car car=(Car) ctx.getBean("car1");
		System.out.println(car);
		
		Car car2=(Car) ctx.getBean("car2");
		System.out.println(car2);
	}
}
