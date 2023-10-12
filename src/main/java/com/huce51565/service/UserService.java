package com.huce51565.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huce51565.entity.Users;
import com.huce51565.modal.dto.UserRequest;
import com.huce51565.modal.dto.UsersDto;

@Service
public interface UserService {
	public List<UsersDto> getListUsers();
	public UsersDto getUserDtoById(String id);
	public Users getUserById(String id);
	public List<UsersDto> searchUserByName(String name);
	//public Users createUser(String id, String fullName, String contact, String password, String adress);
	public Users createUser(Users user);
	public Users updateUser(UserRequest user);
}
