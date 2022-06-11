package com.zhq.annotationbean;

import com.zhq.bean.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ZHQ
 * @date 2022/06/10 16:53
 */
//默认是类名并且首字母小写
@Component //@Service，@Controller，@Repository
public class User {

	@Value("狗子")
	private String username;

	@Value("1234")
	private String password;

	/**
	 * @Autowird：根据类型自动注入
	 * @Autowird+@Qualifier:根据名称自动注入
	 * @Resource：java中的注解，默认通过类型注入，添加name属性通过名称注入
	 */
	@Autowired
	private ClassRoom classRoom;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", classRoom=" + classRoom +
				'}';
	}
}
