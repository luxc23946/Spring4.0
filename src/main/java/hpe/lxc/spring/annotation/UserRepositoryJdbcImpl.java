package hpe.lxc.spring.annotation;

import org.springframework.stereotype.Repository;
/**
 * 持久层
 * @author Administrator
 */
@Repository
public class UserRepositoryJdbcImpl implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserRepositoryJdbcImpl'save...");
	}

}
