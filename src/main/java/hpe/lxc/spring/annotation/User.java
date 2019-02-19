package hpe.lxc.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 组件层
 * @author Administrator
 */
@Component
@Scope("prototype")
public class User {
	
	
	/*
	 * 通过value注解为普通属性赋值
	 */
	@Value("Tom")
	private String name;
	@Value("Male")
	private String sex;
	@Value("20")
	private Integer age;
	
	
	/*
	 * 初始化
	 */
	@PostConstruct
	public void initMethod() {
		System.out.println("User init...");
	}
	
	/*
	 * 销毁
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
