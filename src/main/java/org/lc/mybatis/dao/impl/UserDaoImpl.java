package org.lc.mybatis.dao.impl;

import org.lc.mybatis.dao.IUserDao;
import org.lc.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

/**
 * @author L丶C
 */
public class UserDaoImpl implements IUserDao {
	public SqlSession sqlSession;

	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public User queryUserById(Integer id) {
		return this.sqlSession.selectOne("IUserDao.queryUserById", id);
	}

	@Override
	public List<User> queryUserAll() {
		return this.sqlSession.selectList("IUserDao.queryUserAll");
	}

	@Override
	public void insertUser(User user) {
		this.sqlSession.insert("IUserDao.insertUser", user);
	}

	@Override
	public void updateUser(User user) {
		this.sqlSession.update("IUserDao.updateUser", user);
	}

	@Override
	public void deleteUser(Integer id) {
		this.sqlSession.delete("IUserDao.deleteUser", id);
	}

}
