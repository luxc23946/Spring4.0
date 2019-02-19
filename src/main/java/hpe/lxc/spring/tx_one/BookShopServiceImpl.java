package hpe.lxc.spring.tx_one;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class BookShopServiceImpl implements BookShopService {
	private BookShopDao bookShopDao;
	
	private TransactionTemplate transactionTemplate;
	
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	@Override
	public int purchase(final String username,final int isbn) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				//1.��ȡ��ĵ���
				Float price=bookShopDao.findBookPriceByIsbn(isbn);
				
				//2.������Ŀ��
				bookShopDao.updateBookStock(isbn);
				
				//3.�����û����
				bookShopDao.updateUserAccount(username, price);
				
			}
			
		});
		
		return 1;
	}

}
