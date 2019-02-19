package hpe.lxc.spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args){
		
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/collection/applicationContext-collection"
				+ ".xml");
		Person person1=(Person) ctx.getBean("person1");
		System.out.println(person1);
		
		Person person2=(Person) ctx.getBean("person2");
		System.out.println(person2);
		
		Person person3=(Person) ctx.getBean("person3");
		System.out.println(person3);
		
	}
}
