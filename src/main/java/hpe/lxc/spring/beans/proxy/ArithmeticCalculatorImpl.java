package hpe.lxc.spring.beans.proxy;

/**
 * 不带日志记录的原生实现
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
