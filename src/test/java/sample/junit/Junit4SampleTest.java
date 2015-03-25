package sample.junit;
import com.baobaotao.domain.User;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Junit4SampleTest{
	private User user;

	// ����ǰJUnit�����setUp()�����ͳ�ʼ�����Ի���
	@Before
	public void setUp() throws Exception {
		user = new User("Junit", "1234");
	}

	// ������ɺ�JUnit�����tearDown()������Դ�����ͷŴ򿪵��ļ�,�ر���ݿ����ӵȵ�
	@After
	public void tearDown() throws Exception {
		assertNull(null,user);
	}
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
	}

	// ������ɺ�JUnit�����tearDown()������Դ�����ͷŴ򿪵��ļ�,�ر���ݿ����ӵȵ�
	@AfterClass
	public static void afterClass() throws Exception {
		
	}

	// ����User�û�������
	@Test
	public void testUser() {
		assertEquals("Junit", user.getUserName());
		assertEquals("1234", user.getPassword());// ���������ֹ��ϣ�Ӧ�ð���ߵĲ����Ϊ10

	}

	// ����Hello���е�division����
	@Test(expected=Exception.class)
	public void testUserId() {
	    assertEquals(0, user.getUserId());
	}
  
}
