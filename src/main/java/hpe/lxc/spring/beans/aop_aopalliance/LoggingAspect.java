package hpe.lxc.spring.beans.aop_aopalliance;



import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�ӿڣ��ӿھ��ǹ淶���Ӷ���ȷ���������ơ�
 * * ���á�����֪ͨ��  MethodInterceptor
 */
public class LoggingAspect implements MethodInterceptor {
	

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object result=null;
		
		try {
			
			//ǰ��֪ͨ
			System.out.println("The method:"+mi.getMethod().getName()+"() begins with"+Arrays.asList(mi.getArguments()));
			
			result=mi.proceed();
			
			//����֪ͨ
			System.out.println("The method:"+mi.getMethod().getName()+"() end with:"+result);
			
		} catch (Exception e) {
			
			//�쳣֪ͨ
			System.out.println("The method:"+mi.getMethod().getName()+"() Occurs a exception:"+e.getMessage());
		}
		
		//����֪ͨ
		
		return result;
	}
	
}
