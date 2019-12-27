package org.lc.service.impl;

import org.lc.dao.UserDao;
import org.lc.entity.Page;
import org.lc.entity.User;
import org.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
/**
 * @author
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User check(String userName, String password) {
		return userDao.check(userName, password);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public List<User> queryUserAll() {
		return userDao.queryUserAll();
	}

	@Override
	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
	}

	@Override
	public void updateUserById(User user) {
		userDao.updateUserById(user);
	}

	@Override
	public User queryUserById(Integer id) {
		return userDao.queryUserById(id);
	}

	@Override
	public int getTotalCount() {
		return userDao.getTotalCount();
	}

	@Override
	public void showUserByPage(HttpServletRequest request, Model model) {
		//获取request域中的当前页码
		String currentPage = request.getParameter("currentPage");
		//获取request域中的页面大小
		String pageSize = request.getParameter("pageSize");
		Page page ;
		List<User> user;
		//查询用户总数
		int totalCount = userDao.getTotalCount();
		//如果有当前页
		if (currentPage != null) {
			page = new Page(totalCount, Integer.parseInt(currentPage), Integer.parseInt(pageSize));
			user = this.userDao.queryUserByPage(page.getStartPos(), page.getPageSize());
		}//如果第一次请求，则赋值当前页为1
		else {
			page = new Page(totalCount, 1,2);
			user = userDao.queryUserByPage(page.getStartPos(), page.getPageSize());
		}
		model.addAttribute("user", user);
		model.addAttribute("page", page);
	}
}
