package hpe.lxc.spring.beans.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/annotation/applicationContext-annotation.xml");
        User user=(User) ctx.getBean("user");
        User user2=(User) ctx.getBean("user");

        
	    System.out.println(user.hashCode());
	    System.out.println(user2.hashCode());
	    UserController userController=(UserController) ctx.getBean("userController");
	    userController.execute();
	    
	    
	    ctx.close();
	}
}
