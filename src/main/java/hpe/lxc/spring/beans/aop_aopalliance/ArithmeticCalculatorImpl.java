package hpe.lxc.spring.beans.aop_aopalliance;


/**
 * 切面类中确定通知，需要实现不同接口，接口就是规范，从而就确定方法名称
 * 采用“环绕通知” MethodInterceptor
 * @author Administrator
 *
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		
		int result=i+j;
		
		return result;
	}

	@Override
	public int sub(int i, int j) {
		
		int result=i-j;
		
		return result;
	}

	@Override
	public int mul(int i, int j) {
		
		int result=i*j;
		
		return result;
	}

	@Override
	public int div(int i, int j) {
		
		int result=i/j;
		
		return result;
	}

}
