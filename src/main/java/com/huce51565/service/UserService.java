package com.huce51565.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huce51565.modal.dto.UsersDto;

@Service
public interface UserService {
	public List<UsersDto> getListUsers();
	public UsersDto getUserById(String id);
	public List<UsersDto> searchUserByName(String name);
}
