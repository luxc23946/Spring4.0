package hpe.lxc.spring.annotation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * Web层
 * @author Administrator
 */
@Controller
public class UserController {
	
	/*
	 * @Autowired
	 * @Qualifier("userService")
	 *       等价于 
	 * @Resource("userService")注解
	 */
	@Autowired
	@Qualifier(value="userService")
	private UserService userService;
	
	public void execute(){
		System.out.println("UserController's execute..");
		userService.add();
	}
}
