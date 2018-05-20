package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.dto.UserDTO;

public interface UserService {
	public boolean isExist(User user);
	public void saveUser(User user);
}
