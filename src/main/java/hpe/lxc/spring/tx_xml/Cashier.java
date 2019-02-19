package hpe.lxc.spring.tx_xml;

import java.util.List;

public interface Cashier {
	public void checkOut(String username,List<Integer> isbns);
}
