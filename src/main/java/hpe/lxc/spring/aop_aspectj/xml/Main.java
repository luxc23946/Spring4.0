package hpe.lxc.spring.aop_aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/aop_aspectj/xml/applicationContext-aopxml.xml");
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
	    
		int result=arithmeticCalculator.add(3, 2);
	    System.out.println(result);
	    
	    result=arithmeticCalculator.div(10, 5);
	    System.out.println(result);
	    
	    result=arithmeticCalculator.sub(10, 5);
	    System.out.println(result);
	}
}
