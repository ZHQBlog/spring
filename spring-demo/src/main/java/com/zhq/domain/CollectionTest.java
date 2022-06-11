package com.zhq.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ZHQ
 * @date 2022/06/10 10:21
 */
public class CollectionTest {
	private String[] array;
	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "CollectionTest{" +
				"array=" + Arrays.toString(array) +
				", list=" + list +
				", map=" + map +
				", set=" + set +
				'}';
	}
}
