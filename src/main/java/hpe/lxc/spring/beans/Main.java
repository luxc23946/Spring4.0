package hpe.lxc.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/applicationContext-beans.xml");
		
		Car car0=(Car) ctx.getBean("car0");
		System.out.println(car0);
		
		Car car1=(Car) ctx.getBean("car1");
		System.out.println(car1);
		
		Car car2=(Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person person=(Person) ctx.getBean("person1");
		System.out.println(person);
		
		Person person2=(Person) ctx.getBean("person2");
		System.out.println(person2);
		
	
		
	}
}
