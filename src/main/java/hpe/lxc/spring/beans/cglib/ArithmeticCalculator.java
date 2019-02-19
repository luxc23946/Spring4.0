package hpe.lxc.spring.beans.cglib;

/**
 * 不带日志记录的原生实现
 * @author Administrator
 *
 */
public class ArithmeticCalculator  {

	public int add(int i, int j) {
		
		int result=i+j;
		
		return result;
	}

	public int sub(int i, int j) {
		
		int result=i-j;
		
		return result;
	}

	public int mul(int i, int j) {
		
		int result=i*j;
		
		return result;
	}

	public int div(int i, int j) {
		
		int result=i/j;
		
		return result;
	}

}
