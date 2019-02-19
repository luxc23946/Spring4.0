package hpe.lxc.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * �־ò�
 * @author Administrator
 */
@Repository(value="userRepository")
public class UserRepositoryImpl implements UserRepository {
	
    /**
     * required=false �ƶ����������Ϊnull ��IOC�����п���û�и����
     */
	@Autowired(required=false)
	private User testObject;
	
	@Override
	public void save() {
		System.out.println("UserRepository's save...");
		System.out.println(testObject);
	}

}
