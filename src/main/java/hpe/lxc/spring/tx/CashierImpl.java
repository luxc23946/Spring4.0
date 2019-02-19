package hpe.lxc.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	@Override
	public void checkOut(String username, List<Integer> isbns) {
		for(int isbn:isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
