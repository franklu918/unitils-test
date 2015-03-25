package sample.mockito;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import com.baobaotao.service.UserServiceImpl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockMethodTest {
	// ģ��ӿ�
	UserService mockUserService = mock(UserService.class);
	// ģ��ʵ����
	UserServiceImpl mockServiceImpl = mock(UserServiceImpl.class);

	@Test
	// ģ��ӿ�UserService����
	public void testMockInterface() {
		// ģ��������
		when(mockUserService.findUserByUserName("tom")).thenReturn(new User("tom", "1234"));
		when(mockUserService.hasMatchUser("tom", "1234")).thenReturn(true);
		User user = mockUserService.findUserByUserName("tom");
		boolean isMatch = mockUserService.hasMatchUser("tom", "1234");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);
		// ��֤������Ϊ
		verify(mockUserService).findUserByUserName("tom");
		verify(mockUserService).hasMatchUser("tom", "1234");
	}

	// ģ��ʵ����UserServiceImpl����
	@Test
	public void testMockClass() {
		// ģ��������
		when(mockServiceImpl.findUserByUserName("tom")).thenReturn(new User("tom", "1234"));
		when(mockServiceImpl.hasMatchUser("tom", "1234")).thenReturn(true);
		User user = mockServiceImpl.findUserByUserName("tom");
		boolean isMatch = mockServiceImpl.hasMatchUser("tom", "1234");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);
		// ��֤������Ϊ
		verify(mockServiceImpl).findUserByUserName("tom");
		verify(mockServiceImpl).hasMatchUser("tom", "1234");
	}

}
