package hpe.lxc.spring.aop_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/aop_aspectj/applicationContext-aopAspectJ.xml");
	}

	public static void main(String[] args) {
		
		ArithmeticCalculator proxy=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
	    
		proxy.add(3, 2);
	    System.out.println();
	    
	    proxy.div(10, 5);
	    System.out.println();
	    
	    proxy.sub(10, 5);
	    System.out.println();
	}
}
