package hpe.lxc.spring.tx_one;

public interface BookShopDao {
	public Float findBookPriceByIsbn(int isbn);
	
	/**
	 * ʹ��Ŀ���1
	 * @param isbn
	 * @return
	 */
	public Integer updateBookStock(int isbn);
	
	
	/**
	 * �����û��Ľ��
	 * @param userId
	 * @param price
	 * @return
	 */
	public Integer updateUserAccount(String username, Float price);
	
}
