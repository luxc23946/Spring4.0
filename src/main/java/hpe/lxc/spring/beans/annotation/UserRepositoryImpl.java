package hpe.lxc.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 * @author Administrator
 */
@Repository(value="userRepository")
public class UserRepositoryImpl implements UserRepository {
	
    /**
     * required=false 制定该组件可以为null 即IOC容器中可以没有该组件
     */
	@Autowired(required=false)
	private User testObject;
	
	@Override
	public void save() {
		System.out.println("UserRepository's save...");
		System.out.println(testObject);
	}

}
