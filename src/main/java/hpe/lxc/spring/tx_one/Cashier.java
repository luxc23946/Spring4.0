package hpe.lxc.spring.tx_one;

import java.util.List;

public interface Cashier {
	public void checkOut(String username,List<Integer> isbns);
}
