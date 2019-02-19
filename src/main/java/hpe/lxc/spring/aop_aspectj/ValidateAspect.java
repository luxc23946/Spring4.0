package hpe.lxc.spring.aop_aspectj;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(2)
@Component
@Aspect
public class ValidateAspect {
	
	@Before("execution(public int hpe.lxc.spring.aop_aspectj.ArithmeticCalculatorImpl.*(..))")
	public void validateArgs(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method:"+methodName+"() args is"+args);
	}
}
