package hpe.lxc.spring.beans.annotation;

import org.springframework.stereotype.Repository;
/**
 * �־ò�
 * @author Administrator
 */
@Repository
public class UserRepositoryJdbcImpl implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserRepositoryJdbcImpl'save...");
	}

}
