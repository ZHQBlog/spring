package com.zhq.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZHQ
 * @date 2022/06/11 15:26
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void add(User user){
		userDao.add(user);
	}

	public void update(User user, Integer id){
		userDao.update(user, id);
	}

	public void delete(Integer id){
		userDao.delete(id);
	}

	public int queryCount(){
		return userDao.queryCount();
	}

	public User queryUserById(Integer id){
		return userDao.queryUserById(id);
	}

	public List<User> queryUsers(){
		return userDao.queryUsers();
	}

	public void batchAddUser(List<Object[]> users){
		userDao.batchAddUser(users);
	}

	public void batchUpdateUser(List<Object[]> users){
		userDao.batchUpdateUser(users);
	}

	public void batchDeleteUser(List<Object[]> args){
		userDao.batchDeleteUser(args);
	}

	@Transactional(
			propagation = Propagation.REQUIRED,
			isolation = Isolation.REPEATABLE_READ,
			timeout = -1,
			readOnly = false,
			rollbackFor = {}
	)
	public void test(User user1, Integer id1,
					 User user2, Integer id2){
		userDao.update(user1, id1);
		int a = 10/0;
		userDao.update(user2, id2);
	}
}
