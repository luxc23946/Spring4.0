package hpe.lxc.spring.beans.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

 
/**
 * cglib�ֽ�����ǿ��� û�нӿڣ�ֻ��ʵ���ࡣ������ʱ ����Ŀ��������࣬�Ӷ���Ŀ���������ǿ��
 * jar��
 *    ���ģ�hibernate-distribution-3.6.10.Final\lib\bytecode\cglib\cglib-2.2.jar
 *    ������struts-2.3.15.3\apps\struts2-blank\WEB-INF\lib\asm-3.3.jar
 *    spring-core..jar �Ѿ�����������������
 * @author Administrator
 */
public class ArithmeticCalculatorLoggingCglib {
	
	//1.Ҫ����Ķ���
	private ArithmeticCalculator target;
	//2.������
	private LoggingAspect loggingAspect;
	
	public ArithmeticCalculatorLoggingCglib(ArithmeticCalculator target,LoggingAspect loggingAspect) {
		this.target=target;
		this.loggingAspect=loggingAspect;
	}
	
	
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy=null;
		
		//3.1������
		Enhancer enhancer=new Enhancer();
		
		//3.2ȷ������ Ҫ���ĸ�����д������
		enhancer.setSuperclass(target.getClass());
		
		/*3.3���ûص�����,MethodInterceptor�ӿڵ�Ч��jdk��InvocationHandler�ӿ�
		 * intercept��Ч��jdk��invoke()
		 * ����1,2,3��invokeһ��
		 * ����4.�����Ĵ���
		 */
		
		
		
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object object, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				Object result=null;
				
				try {
					
					/*
					 * ǰ��֪ͨ
					 */
					
					
					loggingAspect.beforeLogging();
					
					
					result=method.invoke(target, args);
					
					//Ч��������ȼ�
					//result=methodProxy.invokeSuper(object, args);
					
					
					loggingAspect.afterLogging();
					
					
					/*
					 * ����֪ͨ���Է��ʵ������ķ���ֵ
					 */
					
				} catch (Exception e) {
					
					/*
					 * �쳣֪ͨ,���Է��ʵ��������ֵ��쳣
					 */
					
				}
				
				/*
				 * ����֪ͨ,��Ϊ�������ܻ���쳣,���Է��ʲ��������ķ���ֵ
				 */
				
				
				return result;
			}
		});
		
		//3.4��������
		proxy=(ArithmeticCalculator) enhancer.create();
		
		return proxy;
	}
}
