package org.lc.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lc.mybatis.pojo.User;

import java.util.List;

/**
 * @author L丶C
 */
public interface IUserDao {

	/**
	 * 根据id查询用户信息
	 *
	 * @param id
	 * @return
	 */
	 User  queryUserById( Integer id);

	/**
	 * 查询所有用户信息
	 *
	 * @return
	 */
	 List<User> queryUserAll();

	/**
	 * 新增用户
	 *
	 * @param user
	 */
	 void insertUser(User user);

	/**
	 *
	 * 根据id更新用户信息
	 *
	 * @param user
	 */
	 void updateUser(User user);

	/**
	 * 根据id删除用户信息
	 *
	 * @param id
	 */
	 void deleteUser(Integer id);

}
