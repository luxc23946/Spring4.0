package hpe.lxc.spring.beans.autowire;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/autowire/applicationContext-autoware.xml");
		Person person=(Person) ctx.getBean("person");
		System.out.println(person);
		
		Person person2=(Person) ctx.getBean("person2");
		System.out.println(person2);
		
		
		
		ctx.close();
	}
	
	
}
