package hpe.lxc.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	
	/**
	 * 事务注解
	 * 1.使用propagation指定事务的传播行为:即当前事务方法被另一个事务方法调用时如何使用当前事务
	 * Propagation.REQUIRED:A如果有事务,B将使用该事务,如果A没有事务,B将创建一个新的事务
	 * Propagation.SUPPORTS:A如果有事务,B将使用该事务,如果A没有事务,B将以非事务执行
	 * Propagation.MANDATORY:A如果有事务,B将使用该事务,如果A没有事务,B将抛异常
	 * Propagation.REQUIRES_NEW:如果A有事务,将A的事务挂起,B创建一个新的事务,如果A没有事务，B将以非事务执行
	 * Propagation.NEVER:如果A有事务，B将抛异常,如果A没有事务，B将以非事务执行
	 * Propagation.NESTED:A和B底层采用保存点机制，形成嵌套事务
	 * 2.isolation:指定事务的隔离级别
	 * 3. 默认情况下Spring的声明式事务对所有的运行时异常进行回滚
	 * rollbackFor对什么异常进行回滚,noRollbackFor对什么异常不进行回滚
	 * 4.readOnly:指定事务是否为只读
	 * 5.timeout指定事务对链接的最长占用时间单位为秒
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=1)
	@Override
	public int purchase(String username, int isbn) {
		//1.获取书的单价
		Float price=bookShopDao.findBookPriceByIsbn(isbn);
		
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		
		//3.更新用户余额
		bookShopDao.updateUserAccount(username, price);
		
		return 1;
	}

}
