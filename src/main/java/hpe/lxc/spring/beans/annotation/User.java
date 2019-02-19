package hpe.lxc.spring.beans.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * �����
 * @author Administrator
 */
@Component
@Scope("prototype")
public class User {
	
	
	/*
	 * ͨ��valueע��Ϊ��ͨ���Ը�ֵ
	 */
	@Value("Tom")
	private String name;
	@Value("Male")
	private String sex;
	@Value("20")
	private Integer age;
	
	
	/*
	 * ��ʼ��
	 */
	@PostConstruct
	public void initMethod() {
		System.out.println("User init...");
	}
	
	/*
	 * ����
	 */
	@PreDestroy
	public void destoryMethod() {
		System.out.println("User destory...");
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
