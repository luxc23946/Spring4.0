package hpe.lxc.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * ���� Bean���ô����� ��Ҫʵ��BeanPostProcessor
 * ��Bean���ô����������ڵ��ó�ʼ������ǰ��� Bean ���ж���Ĵ���.
 * ��Bean ���ô������� IOC ����������� Bean ʵ����һ����, ���ǵ�һʵ��
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
