package org.lc.entity;
/**
 * @author
 */
public class User {
	/**
	 * 	属性名必须与数据库表的字段名一致，以便Mybatis直接把实体类映射成数据库记录
	 */
	private Integer id;
	private String userName;
	private String name;
	private String password;
	private Integer age;
	private String sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				'}';
	}
}
