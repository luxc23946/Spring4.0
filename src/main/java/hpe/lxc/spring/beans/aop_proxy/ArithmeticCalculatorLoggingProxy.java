package hpe.lxc.spring.beans.aop_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 使用动态代理实现日志记录功能
 *   缺点:①实现起来过于复杂
 *       JDK的动态代理只能对接口进行代理
 * @author Administrator
 */
public class ArithmeticCalculatorLoggingProxy {
	
	//要代理的对象
	private ArithmeticCalculator target;
	//切面类
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
			 * obj:正在返回的那个对象,一般情况下,在invoke方法中都不使用该对象
			 * method:正在被调用的方法
			 * args:调用方法时传递的参数
			 */
			public Object invoke(Object obj, Method method, Object[] args)
					throws Throwable {
				System.out.println("The method "+method.getName()+" begins with ["+Arrays.asList(args)+"]"); 
			
				Object result=null;
				try {
					
					/*
					 * 前置通知
					 */
					
					loggingAspect.beforeLogging();
					
					result=method.invoke(target, args);
					
					loggingAspect.afterLogging();
					
					/*
					 * 返回通知可以访问到方法的返回值
					 */
					
				} catch (Exception e) {
					e.printStackTrace();
					
					/*
					 * 异常通知,可以访问到方法出现的异常
					 */
					
				}
						
				
				/*
				 * 后置通知,因为方法可能会出异常,所以访问不到方法的返回值
				 */
				
				System.out.println("The method "+ method.getName()+" ends with "+result);
				return result;
			}
		};
		
		proxy=(ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
}
