package hpe.lxc.spring.beans.aop_aspectj.xml;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAspect {
	
	
	
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+ methodName +" begins with" + args);
	}
	
	
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" ends");
	}
	
	
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" return "+ result);
	}
	
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" occurs exception: "+ ex.getMessage());
	}
	
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
		Object result=null;
		String methodName=proceedingJoinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(proceedingJoinPoint.getArgs());
		try {
			
			/**
			 * ǰ��֪ͨ
			 */
			System.out.println("The method "+ methodName +" begins with" + args);
			
			
			/**
			 * ִ�з�����
			 */
			result=proceedingJoinPoint.proceed();
			
			
		} catch (Throwable e) {			
			
			/**
			 * �쳣֪ͨ
			 */
			System.out.println("The method "+ methodName +" occurs exception:"+e.getMessage());
		}
		
		
		/**
		 * ����֪ͨ
		 */
		System.out.println("The method "+ methodName +" return: "+result);
		
		
		return result;
	}
}
