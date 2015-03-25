package sample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import com.baobaotao.service.UserServiceImpl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoSampleTest {
	//ģ��ӿ�
	UserService mockUserService = mock(UserService.class);
	//ģ��ʵ����
	UserServiceImpl mockServiceImpl = mock(UserServiceImpl.class);
	//����ע��ģ����
    @Mock User mockUser;
    
    @Before 
    public void initMocks() {
    	//��ʼ����ǰ����������@Mockע��ģ�����
        MockitoAnnotations.initMocks(this);
    }
    
	@Test
	//ģ��ӿ�UserService����
	public void testMockInterface() {
		//�Է����趨����ֵ 
		when(mockUserService.findUserByUserName("tom")).thenReturn(
				new User("tom", "1234"));
		doReturn(true).when(mockUserService).hasMatchUser("tom", "1234"); 
		//��void�������з���Ԥ���趨 
		User u = new User("John", "1234");
		doNothing().when(mockUserService).registerUser(u); 
		
		//ִ�з������� 
		User user = mockUserService.findUserByUserName("tom");
		boolean isMatch = mockUserService.hasMatchUser("tom","1234");
		mockUserService.registerUser(u);
		
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);
		
		//��֤������Ϊ
		verify(mockUserService).findUserByUserName("tom");
		//��֤����ֻ����һ��
		verify(mockUserService, times(1)).findUserByUserName("tom");
		//��֤�������ٵ���һ��
		verify(mockUserService, atLeastOnce()).findUserByUserName("tom");
		verify(mockUserService, atLeast(1)).findUserByUserName("tom");
		//��֤�����������һ��
		verify(mockUserService, atMost(1)).findUserByUserName("tom");
		
		verify(mockUserService).hasMatchUser("tom", "1234");
		verify(mockUserService).registerUser(u);

	}

	//ģ��ʵ����UserServiceImpl����
	@Test
	public void testMockClass() {
		//�Է����趨����ֵ
		when(mockServiceImpl.findUserByUserName("tom")).thenReturn(new User("tom", "1234"));
		doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234"); 
		
		User user = mockServiceImpl.findUserByUserName("tom");
		boolean isMatch = mockServiceImpl.hasMatchUser("tom","1234");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);
		//��֤������Ϊ
		verify(mockServiceImpl).findUserByUserName("tom");
		verify(mockServiceImpl).hasMatchUser("tom", "1234");
	}
	

	//ģ��User�����
	@Test
	public void testMockUser() {
		MockitoAnnotations.initMocks(mockUser);
		when(mockUser.getUserId()).thenReturn(1);
		when(mockUser.getUserName()).thenReturn("tom");
		assertEquals(mockUser.getUserId(),1);
		assertEquals(mockUser.getUserName(), "tom");
	}
	
	

}
