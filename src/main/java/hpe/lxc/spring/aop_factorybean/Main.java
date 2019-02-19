package hpe.lxc.spring.aop_factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;
	
	static {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/aop_factorybean/applicationContext.xml");
	}
	
	public static void main(String[] args) {
		ArithmeticCalculator proxy=
				(ArithmeticCalculator) ctx.getBean("proxyArithmeticCalculator");
		proxy.add(5, 5);
		System.out.println();
		
		proxy.sub(2, 5);
		System.out.println();
		
		proxy.div(10, 5);
		System.out.println();
		
		proxy.mul(2, 5);
		System.out.println();
		
	}
}
