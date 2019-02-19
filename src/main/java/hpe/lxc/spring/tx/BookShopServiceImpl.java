package hpe.lxc.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	
	/**
	 * ����ע��
	 * 1.ʹ��propagationָ������Ĵ�����Ϊ:����ǰ���񷽷�����һ�����񷽷�����ʱ���ʹ�õ�ǰ����
	 * Propagation.REQUIRED:A���������,B��ʹ�ø�����,���Aû������,B������һ���µ�����
	 * Propagation.SUPPORTS:A���������,B��ʹ�ø�����,���Aû������,B���Է�����ִ��
	 * Propagation.MANDATORY:A���������,B��ʹ�ø�����,���Aû������,B�����쳣
	 * Propagation.REQUIRES_NEW:���A������,��A���������,B����һ���µ�����,���Aû������B���Է�����ִ��
	 * Propagation.NEVER:���A������B�����쳣,���Aû������B���Է�����ִ��
	 * Propagation.NESTED:A��B�ײ���ñ������ƣ��γ�Ƕ������
	 * 2.isolation:ָ������ĸ��뼶��
	 * 3. Ĭ�������Spring������ʽ��������е�����ʱ�쳣���лع�
	 * rollbackFor��ʲô�쳣���лع�,noRollbackFor��ʲô�쳣�����лع�
	 * 4.readOnly:ָ�������Ƿ�Ϊֻ��
	 * 5.timeoutָ����������ӵ��ռ��ʱ�䵥λΪ��
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=1)
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
