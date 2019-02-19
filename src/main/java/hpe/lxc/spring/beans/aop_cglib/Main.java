package hpe.lxc.spring.beans.aop_cglib;

public class Main {
	public static void main(String[] args) {
		
		
		ArithmeticCalculator proxy=
				new ArithmeticCalculatorLoggingCglib(new ArithmeticCalculator(), new LoggingAspect())
		               .getLoggingProxy();
		int result=0;
		
		result=proxy.add(5, 5);
		System.out.println(result);
		
		
		result=proxy.div(10, 5);
		System.out.println(result);
		
		result=proxy.mul(3, 3);
		System.out.println(result);
		
		result=proxy.sub(10, 5);
		System.out.println(result);
	}
}
