package hpe.lxc.spring.tx;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{
	private ApplicationContext ctx;
	private BookShopDao bookShopDao;
	private BookShopService BookShopService;
	private Cashier cashier;
	
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("hpe/lxc/spring/tx/applicationContext-tx.xml");
		bookShopDao=(BookShopDao) ctx.getBean("bookShopDao");
		BookShopService=(hpe.lxc.spring.tx.BookShopService) ctx.getBean("bookShopService");
		cashier=(Cashier) ctx.getBean("cashier");
	}
	
	@Test
	public void testFindBookPriceByIsbn(){
		Float price=bookShopDao.findBookPriceByIsbn(1001);
		System.out.println(price);
	}
	
	@Test
	public void testUpdateBookStock(){
		int flag=bookShopDao.updateBookStock(1001);
		System.out.println(flag);
	}
	
	@Test
	public void testUpdateUserAccount(){
		int flag=bookShopDao.updateUserAccount("tom", 500f);
		System.out.println(flag);
	}
	
	@Test
	public void testBookShopService(){
		int result=BookShopService.purchase("tom", 1001);
		System.out.println(result);
	}
	
	/**
	 * 测试事务的传播行为
	 */
	@Test
	public void testCheckOut(){
		String username="tom";
		List<Integer>isbns=new ArrayList<Integer>();
		isbns.add(1001);
		isbns.add(1001);
		isbns.add(1002);
		isbns.add(1002);
		cashier.checkOut(username, isbns);
	}
	
}
