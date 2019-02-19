package hpe.lxc.spring.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/factorybean/applicationContext-factoryBean.xml");
		Car car =(Car) ctx.getBean("car");
		System.out.println(car);
	}

}
