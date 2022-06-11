package com.zhq.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ZHQ
 * @date 2022/06/10 10:38
 */
public class CollectionUser {
	private User[] arrayUser;
	private List<User> listUser;
	private Map<String, User> mapUser;
	private Set<User> setUser;

	private List<Map<String, String>> listMap;

	public User[] getArrayUser() {
		return arrayUser;
	}

	public void setArrayUser(User[] arrayUser) {
		this.arrayUser = arrayUser;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public Map<String, User> getMapUser() {
		return mapUser;
	}

	public void setMapUser(Map<String, User> mapUser) {
		this.mapUser = mapUser;
	}

	public Set<User> getSetUser() {
		return setUser;
	}

	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}

	public List<Map<String, String>> getListMap() {
		return listMap;
	}

	public void setListMap(List<Map<String, String>> listMap) {
		this.listMap = listMap;
	}

	@Override
	public String toString() {
		return "CollectionUser{" +
				"arrayUser=" + Arrays.toString(arrayUser) +
				", listUser=" + listUser +
				", mapUser=" + mapUser +
				", setUser=" + setUser +
				", listMap=" + listMap +
				'}';
	}
}
