package com.zhq.annotationtx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZHQ
 * @date 2022/06/11 15:26
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(User user) {
		String sql = "insert into user set username=?,password=?";
		String []args = {user.getUsername(), user.getPassword()};
		int update = jdbcTemplate.update(sql, args);
		System.out.println(update);
	}

	@Override
	public void update(User user, Integer id) {
		String sql = "update user set password=? where id=?";
		String []args = {user.getPassword(), String.valueOf(id)};
		int update = jdbcTemplate.update(sql, args);
		System.out.println(update);
	}

	@Override
	public void delete(int id) {
		String sql = "delete from user where id=?";
		int update = jdbcTemplate.update(sql, id);
		System.out.println(update);
	}

	@Override
	public int queryCount() {
		String sql = "select count(*) from user";
		Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
		return integer;
	}

	@Override
	public User queryUserById(int id) {
		String sql = "select username,password from user where id=?";
		User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
		return user;
	}

	@Override
	public List<User> queryUsers() {
		String sql = "select username,password from user";
		List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

		return userList;
	}

	@Override
	public void batchAddUser(List<Object[]> users) {
		String sql = "insert into user set username=?,password=?";
		int[] ints = jdbcTemplate.batchUpdate(sql, users);
		System.out.println(ints);
	}

	@Override
	public void batchUpdateUser(List<Object[]> users) {
		String sql = "update user set password=? where id=?";
		int[] ints = jdbcTemplate.batchUpdate(sql, users);
		System.out.println(ints);
	}

	@Override
	public void batchDeleteUser(List<Object[]> args) {
		String sql = "delete from user where id=?";
		int[] ints = jdbcTemplate.batchUpdate(sql, args);
		System.out.println(ints);
	}
}
