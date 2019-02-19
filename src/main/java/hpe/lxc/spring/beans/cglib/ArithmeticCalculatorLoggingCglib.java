package hpe.lxc.spring.beans.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

 
/**
 * cglib字节码增强框架 没有接口，只有实现类。在运行时 创建目标类的子类，从而对目标类进行增强。
 * jar包
 *    核心：hibernate-distribution-3.6.10.Final\lib\bytecode\cglib\cglib-2.2.jar
 *    依赖：struts-2.3.15.3\apps\struts2-blank\WEB-INF\lib\asm-3.3.jar
 *    spring-core..jar 已经整合以上两个内容
 * @author Administrator
 */
public class ArithmeticCalculatorLoggingCglib {
	
	//1.要代理的对象
	private ArithmeticCalculator target;
	//2.切面类
	private LoggingAspect loggingAspect;
	
	public ArithmeticCalculatorLoggingCglib(ArithmeticCalculator target,LoggingAspect loggingAspect) {
		this.target=target;
		this.loggingAspect=loggingAspect;
	}
	
	
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy=null;
		
		//3.1核心类
		Enhancer enhancer=new Enhancer();
		
		//3.2确定父类 要对哪个类进行代理代理
		enhancer.setSuperclass(target.getClass());
		
		/*3.3设置回调函数,MethodInterceptor接口等效于jdk的InvocationHandler接口
		 * intercept等效于jdk的invoke()
		 * 参数1,2,3和invoke一样
		 * 参数4.方法的代理
		 */
		
		
		
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object object, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				Object result=null;
				
				try {
					
					/*
					 * 前置通知
					 */
					
					
					loggingAspect.beforeLogging();
					
					
					result=method.invoke(target, args);
					
					//效果和上面等价
					//result=methodProxy.invokeSuper(object, args);
					
					
					loggingAspect.afterLogging();
					
					
					/*
					 * 返回通知可以访问到方法的返回值
					 */
					
				} catch (Exception e) {
					
					/*
					 * 异常通知,可以访问到方法出现的异常
					 */
					
				}
				
				/*
				 * 后置通知,因为方法可能会出异常,所以访问不到方法的返回值
				 */
				
				
				return result;
			}
		});
		
		//3.4创建代理
		proxy=(ArithmeticCalculator) enhancer.create();
		
		return proxy;
	}
}
