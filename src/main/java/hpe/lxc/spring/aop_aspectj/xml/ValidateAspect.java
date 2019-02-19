package hpe.lxc.spring.aop_aspectj.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;


public class ValidateAspect {
	
	public void validateArgs(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" args is"+args);
	}
}
