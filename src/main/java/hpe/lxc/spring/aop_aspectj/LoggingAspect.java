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
 * 日志切面
 * 把该类声明称一个切面:①把该类放入IOC容器中 ②再声明为一个切面
 * 可以使用 Order注解指定切面的优先级,值越小,优先级越高
 */
@Order(1)
@Component
@Aspect
public class LoggingAspect {
	
	
	/**
	 * 定义一个方法,用于声明切入点表达式.一般地,该方法中再不需要添加其他的代码
	 * 使用 Pointcut注解来声明切入点表达式 后面的其他通知直接使用方法名来引用当前的切入点表达式
	 */
	@Pointcut("execution(* hpe.lxc.spring.aop_aspectj.ArithmeticCalculatorImpl.*(int, int))")
	public void declareJoinPonitExpression(){}
	
	
	
	/**
	 * 声明该方法是一个前置通知：在目标方法开始之前执行
	 * public int hpe.lxc.spring.aop.aspectj.ArithmeticCalculatorImpl.add(int, int) 声明只作用与一个方法
	 * public int hpe.lxc.spring.aop.aspectj.ArithmeticCalculatorImpl.a*(int, int) 声明只作用于匹配的方法
	 * public int hpe.lxc.spring.aop.aspectj.ArithmeticCalculatorImpl.*(..)声明作用于该类的所有方法 任意参数
	 */
	@Before("execution(public int hpe.lxc.spring.aop_aspectj.ArithmeticCalculatorImpl.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method:"+ methodName +"() begins with" + args);
	}
	
	
	
	/**
	 * 声明该方法是一个后置通知(在目标方法执行后执行,无论是否发生异常都执行)
	 * 在后置通知中还不能访问目标方法执行返回值!
	 */
	@After("LoggingAspect.declareJoinPonitExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method:"+ methodName +"() ends");
	}
	
	/**
	 * 声明该方法是一个返回通知(在目标方法正常执行后执行,若目标方法发生异常则不执行)
	 * 在返回通知中能访问目标方法执行的返回值
	 */
	@AfterReturning(value="hpe.lxc.spring.aop_aspectj.LoggingAspect.declareJoinPonitExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method:"+ methodName +"() return "+ result);
	}
	
	
	/**
	 * 声明该方法是一个异常通知(在目标方法出现异常时执行)
	 * 可以访问到异常对象;且可以指定捕获特定的异常
	 */
	@AfterThrowing(value="declareJoinPonitExpression()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" occurs exception: "+ ex.getMessage());
	}
	
	
	/**
 	 * 声明该方法是一个环绕通知(需要携带ProceedingJoinPoin类型的参数)
 	 * 环绕通知类似于动态代理的全过程:ProceedingJoinPoint类型的参数可以决定是否执行目标方法
 	 * 且环绕通知必须有返回值,返回值即为目标方法的返回值	 
	 */
	@Around("declareJoinPonitExpression()")
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
		Object result=null;
		String methodName=proceedingJoinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(proceedingJoinPoint.getArgs());
		try {
			
			/**
			 * 前置通知
			 */
			System.out.println("The method "+ methodName +" begins with" + args);
			
			
			/**
			 * 执行方法体
			 */
			result=proceedingJoinPoint.proceed();
			
			
		} catch (Throwable e) {			
			
			/**
			 * 异常通知
			 */
			System.out.println("The method "+ methodName +" occurs exception:"+e.getMessage());
		}
		
		
		/**
		 * 后置通知
		 */
		System.out.println("The method "+ methodName +" return: "+result);
		
		
		return result;
	}
}
