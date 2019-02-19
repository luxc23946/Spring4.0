package hpe.lxc.spring.beans.generic.di_extends;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定义业务层接口
 * @author Administrator
 *
 * @param <T>
 */
public class BaseService<T> {
	
	@Autowired
	protected BaseRepository<T> baseRepository;
	
	public void add() {
		System.out.println("add...");
		System.out.println(baseRepository);
	}
}
