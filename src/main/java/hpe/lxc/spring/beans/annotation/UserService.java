package hpe.lxc.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * 业务层
 * @author Administrator
 */
@Service
public class UserService {
	
	/*
	 * 一
	 */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public void setUserRepository( UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	/*二
	 * 
	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository( UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	*/
	
	/*
	 * 三
	@Autowired
	public void setUserRepository(@Qualifier("userRepository") UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	*/
	
	
	public void add(){
		System.out.println("UserService's add...");
		userRepository.save();
	}
}
