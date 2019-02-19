package hpe.lxc.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/scope/applicationContext-scope.xml");
		Car car=(Car) ctx.getBean("car");
		Car car2=(Car) ctx.getBean("car");
		System.out.println(car.hashCode());
		System.out.println(car2.hashCode());
	}
}
