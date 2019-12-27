package org.lc.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.lc.mybatis.dao.impl.UserDaoImpl;
import org.lc.mybatis.pojo.User;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

	public IUserDao userDao;
	public SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
		// mybatis-config.xml
		String resource = "mybatis_config.xml";
		// 读取配置文件
		InputStream is = Resources.getResourceAsStream(resource);
		// 构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 获取sqlSession
		sqlSession = sqlSessionFactory.openSession();
		this.userDao = new UserDaoImpl(sqlSession);
	}

	@Test
	public void queryUserById() {
		System.out.println(this.userDao.queryUserById(3));
	}

	@Test
	public void insertUser() {
		User user = new User();
		user.setUserName("evan");
		user.setPassword("123456");
		user.setName("大鹏");
		user.setAge(16);
		user.setSex("男");
		this.userDao.insertUser(user);
		this.sqlSession.commit();
	}

	@Test
	public void queryUserAll() {
		List<User> userList = this.userDao.queryUserAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void updateUser() {
		User user = new User();
		user.setId(2);
		user.setUserName("evanli");
		user.setPassword("654321");
		user.setName("阿鹏");
		user.setAge(16);
		user.setSex("男");
		this.userDao.updateUser(user);
		this.sqlSession.commit();
	}

	@Test
	public void deleteUser() {
		this.userDao.deleteUser(2);
		this.sqlSession.commit();
	}

}