package com.huce51565.modal.mapper;

import com.huce51565.entity.Users;
import com.huce51565.modal.dto.UsersDto;

public class UserMapper {
	public static UsersDto toUserDto(Users users) {
		UsersDto tmp = new UsersDto();
		tmp.setId(users.getId());
		tmp.setFullName(users.getFullName());
		tmp.setDateOfBirth(users.getDateOfBirth());
		tmp.setEmail(users.getEmail());
		tmp.setPhoneNumber(users.getPhoneNumber());
		tmp.setAvatar(users.getAvatar());
		tmp.setAddress(users.getAddress());
		tmp.setActiveStatus(users.getActiveStatus());
		tmp.setPriority(users.getPriority());
		return tmp;
	}
}
