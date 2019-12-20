package org.lc.mybatis.pojo;

/**
 * @author L丶C
 */
public class User {
	private Integer id;
	private String userName;
	private String name;
	private String password;
	private Integer age;
	private String sex;


	public String getPassword() {
		return password;
	}

	public String getSex() {
		return sex;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {

		return "User{"+
				" Id: "+id+
				", User_name: " +userName+
				", Password: "+password +
				", Name: "+name+
				", Age: "+age+
				", Sex: "+sex+
				"}";
	}
}
