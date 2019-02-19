package hpe.lxc.spring.tx;

public interface BookShopDao {
	public Float findBookPriceByIsbn(int isbn);
	
	/**
	 * 使书的库存减1
	 * @param isbn
	 * @return
	 */
	public Integer updateBookStock(int isbn);
	
	
	/**
	 * 更新用户的金额
	 * @param userId
	 * @param price
	 * @return
	 */
	public Integer updateUserAccount(String username, Float price);
	
}
