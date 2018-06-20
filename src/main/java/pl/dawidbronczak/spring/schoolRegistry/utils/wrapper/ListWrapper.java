package pl.dawidbronczak.spring.schoolRegistry.utils.wrapper;

import java.util.ArrayList;
import java.util.List;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public class ListWrapper{
	private List<User> list = new ArrayList<>();

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}
