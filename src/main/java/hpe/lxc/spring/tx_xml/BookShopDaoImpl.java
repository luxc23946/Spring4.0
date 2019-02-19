package hpe.lxc.spring.tx_xml;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BookShopDaoImpl extends JdbcDaoSupport implements BookShopDao {

	
	@Override
	public Float findBookPriceByIsbn(int isbn) {
		String sql="select price from book where isbn=?";
		return super.getJdbcTemplate().queryForObject(sql, Float.class,isbn);
	}

	@Override
	public Integer updateBookStock(int isbn) {
		Integer result =0;
		String sql="update book_stock set stock=stock-1 where isbn=?";
		
		String checkSql="select stock from book_stock where isbn=?";
		int account =super.getJdbcTemplate().queryForObject(checkSql, Integer.class,isbn);
		
		//��֤����Ƿ����,������,���׳��쳣
		if(account>0){
			result=super.getJdbcTemplate().update(sql,isbn);
		}else{
			throw new BookStockException("��治��");
		}
		
		return result;
	}

	@Override
	public Integer updateUserAccount(String username, Float price) {
		Integer result=0;
		String sql="update user set balance=balance-? where username=?";
		String checkSql="select balance from user where username=?";
		
		float balance=super.getJdbcTemplate().queryForObject(checkSql, Float.class,username);
		
		
		//��֤����Ƿ����,������,���׳��쳣
		if(balance>=price){
			result=super.getJdbcTemplate().update(sql,price,username);
		}else{
			throw new UserAccountException("�˻�����");
		}
		
		return result;
	}

}
