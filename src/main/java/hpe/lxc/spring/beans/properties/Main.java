package hpe.lxc.spring.beans.properties;


import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) throws SQLException {
		ctx = new ClassPathXmlApplicationContext("hpe/lxc/spring/beans/properties/applicationContext-properties.xml");
	    javax.sql.DataSource dataSource=(javax.sql.DataSource) ctx.getBean("dataSource");
	    DataSource dataSource2=(DataSource) ctx.getBean("ds");
		System.out.println(dataSource.getConnection());
		System.out.println(dataSource2);
	}
	
}
