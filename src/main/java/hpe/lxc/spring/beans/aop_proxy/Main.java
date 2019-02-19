package hpe.lxc.spring.beans.aop_proxy;

public class Main {
	public static void main(String[] args) {
		/*
		ArithmeticCalculator arithmeticCalculator=new ArithmeticCalculatorLoggingImpl();
		int result=0;
		
		result=arithmeticCalculator.add(1, 2);
		System.out.println("-->"+result);
		
		result=arithmeticCalculator.sub(2, 1);
		System.out.println("-->"+result);
		
		result=arithmeticCalculator.mul(3, 4);
		System.out.println("-->"+result);
		
		result=arithmeticCalculator.div(10, 5);
		System.out.println("-->"+result);
		
		System.out.println("----------------------------");
		*/
		
		
		
		ArithmeticCalculator arithmeticCalculator=new ArithmeticCalculatorImpl();
		LoggingAspect loggingAspect=new LoggingAspect();
		
		ArithmeticCalculator proxy=
				new ArithmeticCalculatorLoggingProxy(arithmeticCalculator,loggingAspect)
		        .getLoggingProxy();
		int result=0;
		
		result=proxy.add(1, 2);
		System.out.println("-->"+result);
		
		result=proxy.sub(2, 1);
		System.out.println("-->"+result);
		
		result=proxy.mul(3, 4);
		System.out.println("-->"+result);
		
		result=proxy.div(10, 5);
		System.out.println("-->"+result);
		
	}
}
