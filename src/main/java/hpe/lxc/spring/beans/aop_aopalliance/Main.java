package hpe.lxc.spring.beans.aop_aopalliance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/aop_aopalliance/applicationContext-aop.xml");
	}
	
	public static void main(String[] args) {
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
	    
		arithmeticCalculator.add(3, 2);
	    System.out.println();
		
	    arithmeticCalculator.div(10, 5);
	    System.out.println();
	    
	    arithmeticCalculator.sub(10, 5);
	}
}
