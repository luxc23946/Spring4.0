package hpe.lxc.spring.beans.aop_aopalliance;


/**
 * ��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�ӿڣ��ӿھ��ǹ淶���Ӷ���ȷ����������
 * ���á�����֪ͨ�� MethodInterceptor
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
