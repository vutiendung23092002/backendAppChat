package com.huce51565.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.huce51565.entity.Users;
import com.huce51565.modal.dto.UsersDto;
import com.huce51565.modal.mapper.UserMapper;

@Component
public class UserServiceImpl implements UserService {
	private static ArrayList<Users> users = new ArrayList<Users>();
	static {
		users.add(new Users("user1", "Nguyễn Văn An", "0896011465", "51565239", "Kim Đồng"));
		users.add(new Users("user2", "Đặng Thành Nam", "nam@gmail.com", "123456", "Kim Giang"));
		users.add(new Users("user3", "Vũ Tiến Dũng", "dung@gmail.com", "dungdeptrai", "Nam Định"));
		users.add(new Users("user4", "Trần Thị Hằng", "hang@gmail.com", "hang123", "Hà Nội"));
		users.add(new Users("user5", "Lê Minh Tuấn", "tuan@gmail.com", "tuan123", "Hải Phòng"));
		users.add(new Users("user6", "Phạm Thị Mai", "mai@gmail.com", "mai123", "Hưng Yên"));
		users.add(new Users("user7", "Nguyễn Văn Bình", "binh@gmail.com", "binh123", "Thái Bình"));
		users.add(new Users("user8", "Nguyễn Thị Lan", "lan@gmail.com", "lan123", "Quảng Ninh"));
		users.add(new Users("user9", "Hoàng Văn Đức", "duc@gmail.com", "ducdeptrai", "Vĩnh Phúc"));
		users.add(new Users("user10", "Nguyễn Thị Hoa", "hoa@gmail.com", "hoadept", "Thái Nguyên"));
	}
	
	public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

	@Override
	public List<UsersDto> getListUsers() {
		// TODO Auto-generated method stub
		List<UsersDto> result = new ArrayList<UsersDto>();
		for(Users user: users) {
			result.add(UserMapper.toUserDto(user));
		}
		return result;
	}

	@Override
	public UsersDto getUserById(String id) {
		// TODO Auto-generated method stub
		for(Users user: users) {
			if(user.getId().equals(id)) {
				return UserMapper.toUserDto(user);
			}
		}
		return null;
	}
	
	@Override
	public List<UsersDto> searchUserByName(String name) {
		List<UsersDto> result = new ArrayList<UsersDto>();
		for(Users user : users) {
			if(deAccent(user.getFullName()).contains(deAccent(name))) {
				result.add(UserMapper.toUserDto(user));
			}
		}
		return result;
	}
}



























