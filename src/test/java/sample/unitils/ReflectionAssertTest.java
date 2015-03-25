package sample.unitils;

import java.util.*;
import org.junit.Test;
import static org.unitils.reflectionassert.ReflectionAssert.*;
import static org.unitils.reflectionassert.ReflectionComparatorMode.*;
import com.baobaotao.domain.User;
public class ReflectionAssertTest {
	@Test
	public void testReflectionEquals(){
		User user1 = new User("tom","1234");
		User user2 = new User("tom","1234");
	    assertReflectionEquals(user1, user2);
	}
	@Test
	public void testArrayLenientEquals(){
	    Integer orderList1[] = new Integer[]{1,2,3};
	    Integer orderList2[] = new Integer[]{3,2,1};
	    
	    //�������������ֵ�Ƿ���ȣ�����˳��
	    assertLenientEquals(orderList1, orderList2);
	    assertReflectionEquals(orderList1, orderList2,LENIENT_ORDER);
	    
	    //�������������ֵ�Ƿ���ȣ�����ʱ��ֵ�Ƿ����
	    User user1 = new User("tom","1234");
		Calendar cal1 = Calendar.getInstance();
		user1.setLastVisit(cal1.getTime());
		User user2 = new User("tom","1234");
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DATE, 15);
		user2.setLastVisit(cal2.getTime());
		assertReflectionEquals(user1, user2,LENIENT_DATES);
		assertLenientEquals(user1, user2);
		
	}
	
	@Test
	public void testPropertyLenientEquals(){
		User user = new User("tom","1234");
		assertPropertyReflectionEquals("userName", "tom", user);
		assertPropertyLenientEquals("lastVisit", null, user);
	}

}
