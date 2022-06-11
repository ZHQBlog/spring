package com.zhq.annotationtx;

import java.util.List;

/**
 * @author ZHQ
 * @date 2022/06/11 15:26
 */
public interface UserDao {
	public void add(User user);  //添加用户
	public void update(User user, Integer id);  //修改用户
	public void delete(int id);  //删除用户
	public int queryCount();   //查询数量
	public User queryUserById(int id);  //查询某本书
	public List<User> queryUsers();   //查询所有书
	public void batchAddUser(List<Object[]> userrs);  //批量添加用户
	public void batchUpdateUser(List<Object[]> users);  //批量修改用户
	public void batchDeleteUser(List<Object[]> args);  //批量删除用户
}
