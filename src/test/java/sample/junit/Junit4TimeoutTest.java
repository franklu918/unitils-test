package sample.junit;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.baobaotao.domain.User;

//��ʱ���� 
public class Junit4TimeoutTest {
	private User user;
	
    @Before 
    public void init() { 
    	user = new User("tom","1234");
    } 
	
	//������ָ��ָ��ʱ���ھ���ȷ
	@Test(timeout = 10)
	public void testUser(){
        assertNotNull(user);
        assertEquals("tom", user.getUserName());
	}
}
