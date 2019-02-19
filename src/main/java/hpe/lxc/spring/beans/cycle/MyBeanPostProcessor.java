package hpe.lxc.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * 创建 Bean后置处理器 需要实现BeanPostProcessor
 * ①Bean后置处理器允许在调用初始化方法前后对 Bean 进行额外的处理.
 * ②Bean 后置处理器对 IOC 容器里的所有 Bean 实例逐一处理, 而非单一实例
 * @author Administrator
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessAfterInitialization:"+beanName+","+bean);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessBeforeInitialization:"+beanName+","+bean);
		Car car=(Car) bean;
		car.setBrand("Ford");
		return car;
	}

}
