package hpe.lxc.spring.tx;

import java.util.List;

public interface Cashier {
	public void checkOut(String username,List<Integer> isbns);
}
