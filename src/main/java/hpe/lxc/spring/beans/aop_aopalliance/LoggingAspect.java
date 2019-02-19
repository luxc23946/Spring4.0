package hpe.lxc.spring.beans.aop_aopalliance;



import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类中确定通知，需要实现不同接口，接口就是规范，从而就确定方法名称。
 * * 采用“环绕通知”  MethodInterceptor
 */
public class LoggingAspect implements MethodInterceptor {
	

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object result=null;
		
		try {
			
			//前置通知
			System.out.println("The method:"+mi.getMethod().getName()+"() begins with"+Arrays.asList(mi.getArguments()));
			
			result=mi.proceed();
			
			//后置通知
			System.out.println("The method:"+mi.getMethod().getName()+"() end with:"+result);
			
		} catch (Exception e) {
			
			//异常通知
			System.out.println("The method:"+mi.getMethod().getName()+"() Occurs a exception:"+e.getMessage());
		}
		
		//返回通知
		
		return result;
	}
	
}
