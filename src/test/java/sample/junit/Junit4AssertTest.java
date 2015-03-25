package sample.junit;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import com.baobaotao.domain.User;

public class Junit4AssertTest {
	private User tom;
	private User john;
	@Before
	public void init() {
		tom = new User("tom","1234");
		tom.setCredits(100);
		john = new User("john","1234");
		john.setCredits(50);
	}

	@Test
	public void testAssert() {

		// ����user1�ķ���IP�Ƿ����user2�ķ���IP
		assertEquals(tom.getLastIp(), tom.getLastIp());

		// ����user1�Ƿ�Ϊ��
		assertNotNull(tom);

		// ����user1��user2���ò���ͬһ������
		assertNotSame(tom, john);
		
		// ����user1���û����Ƿ��"om"
		assertThat( tom.getUserName(), containsString( "om" ) );

	}
	
	@Test
	public void testArrayAssert() {
		 String users[] = new String[]{"tom","john","tony"};
		 assertArrayEquals(new String[]{"tom","john","tony"}, users);
	}
	
	@Test
	public void testAasertThat() {

		// 1. ��ֵƥ���
		// ���Ա�����ֵ�Ƿ����ָ��ֵ
		assertThat(tom.getCredits(), greaterThan(50));
		// ���Ա�����ֵС��ָ��ֵʱ
		assertThat(tom.getCredits(), lessThan(150));
		// ���Ա�����ֵ���ڵ���ָ��ֵ
		assertThat(tom.getCredits(), greaterThanOrEqualTo(100));
		// ���Ա�����ֵС�ڵ���ָ��ֵ
		assertThat(tom.getCredits(), lessThanOrEqualTo(100));

		// ���������������붼����
		assertThat(tom.getCredits(), allOf(greaterThan(50), lessThan(150)));
		// ����ֻҪ��һ����������
		assertThat(tom.getCredits(), anyOf(greaterThan(50), lessThan(200)));
		// ��������ʲô��������
		assertThat(tom.getCredits(), anything());
		// ���Ա�����ֵ����ָ��ֵ
		assertThat(tom.getCredits(), is(100));
		// ���Ժ�is�෴��������ֵ������ָ��ֵ
		assertThat(tom.getCredits(), not(50));

		// 2. �ַ�ƥ���
		String url = "http://www.baobaotao.com";
		// �����ַ�����а�ָ���ַ�
		assertThat(url, containsString("baobaotao.com"));
		// �����ַ������ָ���ַ�ͷ
		assertThat(url, startsWith("http://"));
		// �����ַ������ָ���ַ��β
		assertThat(url, endsWith(".com"));
		// �����ַ��������ָ���ַ�
		assertThat(url, equalTo("http://www.baobaotao.com"));
		// �����ַ�����ں��Դ�Сд������µ���ָ���ַ�
		assertThat(url, equalToIgnoringCase("http://www.BAOBAOTAO.com"));
		// �����ַ�����ں���ͷβ����ո������µ���ָ���ַ�
		assertThat(url, equalToIgnoringWhiteSpace(" http://www.baobaotao.com "));

		// 2. ����ƥ���
		List<User> users = new ArrayList();
		users.add(tom);
		users.add(john);
		// ���Ա������Ƿ���ָ��Ԫ��
		assertThat(users, hasItem(tom));
		assertThat(users, hasItem(john));

		// 3. Mapƥ���
		Map<String, User> userMap = new HashMap();
		userMap.put(tom.getUserName(), tom);
		userMap.put(john.getUserName(), john);
		// ����Map�������Ƿ���ָ����ֵ��
		assertThat(userMap, hasEntry(tom.getUserName(), tom));
		// ����Map�������Ƿ���ָ����
		//assertThat(userMap, hasKey(john.getUserName()));
		// ����Map�������Ƿ���ָ��ֵ
		//assertThat(userMap, hasValue(john));
	}
}
