package sample.junit;

import com.baobaotao.domain.User;

import junit.framework.TestCase;

public class Junit38SampleTest extends TestCase {
	private User user;

	// ����ǰJUnit�����setUp()�����ͳ�ʼ�����Ի���
	protected void setUp() throws Exception {
		super.setUp(); // ע�⣺��Junit3.8.1������Ҫ���ø����setUp()
		user = new User("Junit", "1234");
	}

	// ������ɺ�JUnit�����tearDown()������Դ�����ͷŴ򿪵��ļ�,�ر���ݿ����ӵȵ�
	protected void tearDown() throws Exception {
		super.tearDown(); // ע�⣺��Junit3.8.1������Ҫ���ø����tearDown()
		if (user == null) {
			System.out.println("������Դ�ɹ�������");
		}
	}

	// ����User�û�������
	public void testUser() {
		assertEquals("Junit", user.getUserName());
		assertEquals("1234", user.getPassword());// ���������ֹ��ϣ�Ӧ�ð���ߵĲ����Ϊ10

	}

	// ����Hello���е�division����
	public void testUserId() {
		try {
			assertEquals(0, user.getUserId());
			fail("�û�IDΪ�գ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
