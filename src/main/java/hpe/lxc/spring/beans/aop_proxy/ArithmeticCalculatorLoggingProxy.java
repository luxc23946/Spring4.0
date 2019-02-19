package hpe.lxc.spring.beans.aop_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * ʹ�ö�̬����ʵ����־��¼����
 *   ȱ��:��ʵ���������ڸ���
 *       JDK�Ķ�̬����ֻ�ܶԽӿڽ��д���
 * @author Administrator
 */
public class ArithmeticCalculatorLoggingProxy {
	
	//Ҫ����Ķ���
	private ArithmeticCalculator target;
	//������
	private LoggingAspect loggingAspect;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target,LoggingAspect loggingAspect) {
		this.target=target;
		this.loggingAspect=loggingAspect;
	}
	
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy=null;
		
		
		ClassLoader loader=this.getClass().getClassLoader();

		Class<?>[] interfaces=target.getClass().getInterfaces();
		
		InvocationHandler handler=new InvocationHandler() {
			@Override
			/**
			 * obj:���ڷ��ص��Ǹ�����,һ�������,��invoke�����ж���ʹ�øö���
			 * method:���ڱ����õķ���
			 * args:���÷���ʱ���ݵĲ���
			 */
			public Object invoke(Object obj, Method method, Object[] args)
					throws Throwable {
				System.out.println("The method "+method.getName()+" begins with ["+Arrays.asList(args)+"]"); 
			
				Object result=null;
				try {
					
					/*
					 * ǰ��֪ͨ
					 */
					
					loggingAspect.beforeLogging();
					
					result=method.invoke(target, args);
					
					loggingAspect.afterLogging();
					
					/*
					 * ����֪ͨ���Է��ʵ������ķ���ֵ
					 */
					
				} catch (Exception e) {
					e.printStackTrace();
					
					/*
					 * �쳣֪ͨ,���Է��ʵ��������ֵ��쳣
					 */
					
				}
						
				
				/*
				 * ����֪ͨ,��Ϊ�������ܻ���쳣,���Է��ʲ��������ķ���ֵ
				 */
				
				System.out.println("The method "+ method.getName()+" ends with "+result);
				return result;
			}
		};
		
		proxy=(ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
}
