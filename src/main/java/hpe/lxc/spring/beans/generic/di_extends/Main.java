package hpe.lxc.spring.beans.generic.di_extends;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/generic/di_extends/applicationContext-di_extends.xml");
		UserService userService=(UserService) ctx.getBean("userService");
		userService.add();
	}
}
