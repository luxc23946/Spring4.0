package hpe.lxc.spring.beans.annotation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * Web��
 * @author Administrator
 */
@Controller
public class UserController {
	
	/*
	 * @Autowired
	 * @Qualifier("userService")
	 *       �ȼ��� 
	 * @Resource("userService")ע��
	 */
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public void execute(){
		System.out.println("UserController's execute..");
		userService.add();
	}
}
