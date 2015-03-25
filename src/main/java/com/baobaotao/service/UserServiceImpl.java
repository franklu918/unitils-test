package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
@Service("userService")
public class UserServiceImpl implements UserService {
	/*
	 * 当我们在 Spring 容器中配置了两个类型相同的 Bean时,可用
	 * @Qualifier 注解指定注入 Bean 的名称，这样歧义就消除了
	 	注：@Autowired 和 @Qualifier 结合使用时，自动注入的策略就从 byType 转变成 byName 了
	 */
    @Autowired
    @Qualifier("jdbcUserDao")
	private UserDao userDao;
    @Autowired
    @Qualifier("hibernateUserDao")
	private UserDao hibernateUserDao;
    @Autowired
    @Qualifier("jdbcLoginLogDao")
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {
		int matchCount =userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user) {
		user.setCredits( 5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
	}	

	

	public void registerUser(User user) {
		userDao.save(user);	
	}
}
