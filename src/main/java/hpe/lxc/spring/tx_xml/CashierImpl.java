package hpe.lxc.spring.tx_xml;

import java.util.List;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkOut(String username, List<Integer> isbns) {
		for(int isbn:isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
