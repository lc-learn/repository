package org.lc.dao;

import org.apache.ibatis.annotations.*;
import org.lc.entity.Page;
import org.lc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao类:从数据库存取数据的逻辑会放置在 DAO 层（Date Access Object，数据访问对象），
 * 接口中的方法与Mapper映射文件中的SQL语句的ID一一对应，也可以直接在方法上使用注解
 * @author
 */

@Repository
public interface UserDao {
	/**
	 * 验证账户、密码
	 * @param userName
	 * @param password
	 * @return user
	 */
	@Select("select * from tb_user where userName=#{arg0} and password=#{arg1}")
	public User check(String userName,String password);
	/**
	 * 查询用户信息
	 * @return list
	 */
	@Select("select * from tb_user")
	public List<User>  queryUserAll();
	/**
	 * 添加用户信息
	 * @param user
	 * 用于新增用户
	 */
	@Insert("INSERT INTO tb_user (userName,Password,Name,Age,Sex ) VALUES(#{userName},#{password},#{name},#{age},#{sex} )")
	public void insertUser(User user);
	/**
	 * @param id
	 *根据id删除用户信息
	 */
	@Delete("Delete from tb_user where id = #{arg0}")
	public void deleteUserById(Integer id);
	/**
	 * 根据id修改用户信息
	 * @param user
	 */
	@Update("update tb_user set userName = #{userName}, Password = #{password}, Name = #{name},Age = #{age},Sex = #{sex} WHERE id = #{id} ")
	 public void updateUserById(User user);
	 /**
	 *根据id查找用户信息
	 * @param id
	 * @return user
	 */
	@Select("Select * from tb_user where id = #{arg0}")
	public User queryUserById(Integer id);

	/**
	 * 查询总数
	 * @return 数据总数
	 */
	@Select("SELECT count(*) FROM tb_user ")
	public int getTotalCount();
	/**
	 * 查询当前页用户集合
	 * @param startPos
	 * @param pageSize
	 * @return 用户集合
	 */
	@Select("select * from tb_user limit  #{startPos},#{pageSize}")
	public  List<User> queryUserByPage(@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize);
}
