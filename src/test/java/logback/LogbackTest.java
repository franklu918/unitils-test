/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package logback;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *  logback 初始化时创建logback上下文顺序（一旦找到就返回）：
 *  logback.configurationFile （在系统环境里查询此属性） ->
	logback.groovy （文件） ->
	logback-test.xml （文件）->
	logback-test.xml（文件）->
	上述都没成功时，黑夜创建基本的logger
 * 
 * @author 周光明
 * @File LogbackTest.java Date: Dec 26, 20133:59:56 PM-0400 2013
 * @since 1.0
 */
public class LogbackTest {

	@Test
	public void test() {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		Logger logger2 = LoggerFactory.getLogger(LogbackTest.class);
		logger.debug("debug-");
		logger.info("info---");
		logger.warn("warn--");
		
		logger.error(logger.getName());
		logger2.error(logger2.getName());
	}
}
