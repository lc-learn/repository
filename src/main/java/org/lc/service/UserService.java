package org.lc.service;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lc.entity.Page;
import org.lc.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 用户服务类
 *	@author
 */
public interface UserService {
	/**
	 * 验证账户、密码
	 * @param userName
	 * @param password
	 * @return user
	 */
	public User check(String userName,String password);
	/**
	 * 查询用户信息
	 * @return list
	 */
	public List<User>  queryUserAll();
	/**
	 * 添加用户信息
	 * @param user
	 * 用于新增用户
	 */
	public void insertUser(User user);
	/**
	 * 根据id删除用户信息
	 * @param id
	 */
	public void deleteUserById(Integer id);
	/**
	 * 根据id修改用户信息
	 * @param user
	 */
	public void updateUserById(User user);
	/**
	 *根据id查找用户信息
	 * @param id
	 * @return user
	 */
	public User queryUserById(Integer id);


	/**
	 * 查询总数
	 */
	public int getTotalCount();
	/**
	 * 查询当前页用户集合
	 * @param request 获取页面中的currentPage
	 * @param model
	 */
	public void showUserByPage(HttpServletRequest request, Model model);

}
