package hpe.lxc.spring.beans.proxy;

/**
 * ��־����
 * @author Administrator
 *
 */
public class LoggingAspect {
	
	public void beforeLogging() {
		System.out.println("LoggingAspect's beforeLogging");
	}
	
	public void afterLogging() {
		System.out.println("LoggingAspect's afterLogging");
	}
	
}
