package org.lc.controller;

import org.lc.entity.User;
import org.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 */
@Controller
@RequestMapping("User")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 跳转到增加用户页面
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "addUser";
	}
	/**
	 * 查看用户信息
	 */
	@RequestMapping("toView")
	public String toView(){
		return "viewUser";
	}
	/**
	 * 验证用户名和密码
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("check")
	public String checkUser( String userName,String password){
		//如果在数据库中查找到用户，则跳转到按页查找数据的请求
		if (userService.check(userName,password)!=null){
			return "redirect:/User/queryUserByPage";
		}
		return "redirect:/index.jsp";
	}

	/**
	 * 按页查找数据
	 */
	@RequestMapping("queryUserByPage")
	public String queryUserByPage(HttpServletRequest request, Model model){
		//获取数据  request域中的currentPage
		//携带数据  model中的			user：按页找到的用户数据		page：totalCount、currentPage、pageSize
		userService.showUserByPage(request, model);
		return "allUserByPage";
	}

	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("addUser")
	public String addUser(User user){
		userService.insertUser(user);
		return "redirect:/User/queryUserByPage";
	}
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteUser/id={id}")
	public String deleteUserById(@PathVariable("id") Integer id){
		userService.deleteUserById(id);
		return "redirect:/User/queryUserByPage";
	}
	/**
	 * 根据id修改用户信息
	 */
	@RequestMapping("updateUser")
	public String updateUserById(User user){
		userService.updateUserById(user);
		return "redirect:/User/queryUserByPage";
	}
	/**
	 * 根据id查看用户
	 * @param id
	 * @return
	 */
	@RequestMapping("viewUser/id={id}")
	public String ViewUserById(@PathVariable("id") Integer id,Model model){
		User user = userService.queryUserById(id);
		model.addAttribute(user);
		return "viewUser";
	}

}
