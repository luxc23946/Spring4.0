package hpe.lxc.spring.tx_xml;


public class BookShopServiceImpl implements BookShopService {
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
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
