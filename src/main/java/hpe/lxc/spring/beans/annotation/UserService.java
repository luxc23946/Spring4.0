package hpe.lxc.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * ҵ���
 * @author Administrator
 */
@Service
public class UserService {
	
	/*
	 * һ
	 */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public void setUserRepository( UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	/*��
	 * 
	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository( UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	*/
	
	/*
	 * ��
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
