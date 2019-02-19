package hpe.lxc.spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/relation/ApplicationContext-relation.xml");
		
		
		Address address1=(Address) ctx.getBean("address1");
		System.out.println(address1);
		
		Address address2=(Address) ctx.getBean("address2");
		System.out.println(address2);
		
		Person person=(Person) ctx.getBean("person");
		System.out.println(person);
	}
}
