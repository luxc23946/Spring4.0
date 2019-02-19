package hpe.lxc.spring.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Spring整合Junit
 *   ①导入spring-test-4.0.0.RELEASE.jar
 *   ②不需要配置自动扫描的包
 * @author Administrator
 *
 */

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:hpe/lxc/spring/junit/applicationContext.xml")
public class Main {
	 
	@Autowired
	private Car car;
	
    @Test
	public void demo1() {
		System.out.println(car);
	}
}
