package hpe.lxc.spring.aop_aspectj;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ��־����
 * �Ѹ���������һ������:�ٰѸ������IOC������ ��������Ϊһ������
 * ����ʹ�� Orderע��ָ����������ȼ�,ֵԽС,���ȼ�Խ��
 */
@Order(1)
@Component
@Aspect
public class LoggingAspect {
	
	
	/**
	 * ����һ������,���������������ʽ.һ���,�÷������ٲ���Ҫ��������Ĵ���
	 * ʹ�� Pointcutע���������������ʽ ���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ
	 */
	@Pointcut("execution(* hpe.lxc.spring.aop_aspectj.ArithmeticCalculatorImpl.*(int, int))")
	public void declareJoinPonitExpression(){}
	
	
	
	/**
	 * �����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 * public int hpe.lxc.spring.aop.aspectj.ArithmeticCalculatorImpl.add(int, int) ����ֻ������һ������
	 * public int hpe.lxc.spring.aop.aspectj.ArithmeticCalculatorImpl.a*(int, int) ����ֻ������ƥ��ķ���
	 * public int hpe.lxc.spring.aop.aspectj.ArithmeticCalculatorImpl.*(..)���������ڸ�������з��� �������
	 */
	@Before("execution(public int hpe.lxc.spring.aop_aspectj.ArithmeticCalculatorImpl.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method:"+ methodName +"() begins with" + args);
	}
	
	
	
	/**
	 * �����÷�����һ������֪ͨ(��Ŀ�귽��ִ�к�ִ��,�����Ƿ����쳣��ִ��)
	 * �ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�з���ֵ!
	 */
	@After("LoggingAspect.declareJoinPonitExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method:"+ methodName +"() ends");
	}
	
	/**
	 * �����÷�����һ������֪ͨ(��Ŀ�귽������ִ�к�ִ��,��Ŀ�귽�������쳣��ִ��)
	 * �ڷ���֪ͨ���ܷ���Ŀ�귽��ִ�еķ���ֵ
	 */
	@AfterReturning(value="hpe.lxc.spring.aop_aspectj.LoggingAspect.declareJoinPonitExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method:"+ methodName +"() return "+ result);
	}
	
	
	/**
	 * �����÷�����һ���쳣֪ͨ(��Ŀ�귽�������쳣ʱִ��)
	 * ���Է��ʵ��쳣����;�ҿ���ָ�������ض����쳣
	 */
	@AfterThrowing(value="declareJoinPonitExpression()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" occurs exception: "+ ex.getMessage());
	}
	
	
	/**
 	 * �����÷�����һ������֪ͨ(��ҪЯ��ProceedingJoinPoin���͵Ĳ���)
 	 * ����֪ͨ�����ڶ�̬�����ȫ����:ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
 	 * �һ���֪ͨ�����з���ֵ,����ֵ��ΪĿ�귽���ķ���ֵ	 
	 */
	@Around("declareJoinPonitExpression()")
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
