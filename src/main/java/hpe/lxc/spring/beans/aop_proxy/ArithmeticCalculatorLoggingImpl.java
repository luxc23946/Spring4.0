package hpe.lxc.spring.beans.aop_proxy;

/**
 * ����־��¼��ʵ��
 *  ȱ�� 
 *     �ٴ������:Խ��Խ��ķ�ҵ������(��־����֤��)�����, ԭ�е�ҵ�񷽷���������.ÿ�������ڴ�������߼���ͬʱ�����������������ע��.
 *     �ڴ����ɢ:����־����Ϊ��,ֻ��Ϊ�����������һ����, �Ͳ��ò��ڶ��ģ�飨�����������ظ���ͬ����־����. �����־�������仯, �����޸�����ģ��.
 * @author Administrator
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		//��־��ʼ
		System.out.println("The method add begins with ["+i+","+j+"]"); 
		
		int result=i+j;
		//��־����
		System.out.println("The method add ends with "+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		//��־��ʼ
		System.out.println("The method sub begins with ["+i+","+j+"]");
		
		int result=i-j;
		//��־����
		System.out.println("The method sub ends with "+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		//��־��ʼ
		System.out.println("The method mul begins with ["+i+","+j+"]");
		
		int result=i*j;
		//��־����
		System.out.println("The method mul ends with "+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		//��־��ʼ
		System.out.println("The method div begins with ["+i+","+j+"]");
		
		int result=i/j;
		//��־����
		System.out.println("The method div ends with "+result);
		return result;
	}

}
