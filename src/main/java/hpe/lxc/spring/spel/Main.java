package hpe.lxc.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/spel/applicationContext-spel.xml");
		Address address=(Address) ctx.getBean("address");
		System.out.println(address);
		
		Car car=(Car) ctx.getBean("car");
		System.out.println(car);
		
		Person person=(Person) ctx.getBean("person");
		System.out.println(person);
	}
}
