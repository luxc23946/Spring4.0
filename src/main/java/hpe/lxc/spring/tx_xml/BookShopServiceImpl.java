package hpe.lxc.spring.tx_xml;


public class BookShopServiceImpl implements BookShopService {
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Override
	public int purchase(String username, int isbn) {
		//1.��ȡ��ĵ���
		Float price=bookShopDao.findBookPriceByIsbn(isbn);
		
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		
		//3.�����û����
		bookShopDao.updateUserAccount(username, price);
		
		return 1;
	}

}
