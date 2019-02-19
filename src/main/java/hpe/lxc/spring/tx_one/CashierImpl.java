package hpe.lxc.spring.tx_one;

import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	//��Ҫspringע��ģ��
	private TransactionTemplate transactionTemplate;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	@Override
	public void checkOut(final String username, final List<Integer> isbns) {
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				for(int isbn:isbns){
					bookShopService.purchase(username, isbn);
				}
			}
		});
	}

}
