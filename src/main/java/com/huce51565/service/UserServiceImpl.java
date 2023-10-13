package com.huce51565.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.huce51565.entity.Users;
import com.huce51565.exception.NotFoundException;
import com.huce51565.modal.dto.UserRequest;
import com.huce51565.modal.dto.UsersDto;
import com.huce51565.modal.mapper.UserMapper;

@Component
public class UserServiceImpl implements UserService {
	private static ArrayList<Users> users = new ArrayList<Users>();
	static {
		users.add(new Users("user1", "Nguyễn Văn An", "23/09/2002", "0896011465", "51565239", "Kim Đồng"));
		users.add(new Users("user2", "Đặng Thành Nam", "23/09/2002", "nam@gmail.com", "123456", "Kim Giang"));
		users.add(new Users("user3", "Vũ Tiến Dũng", "23/09/2002", "dung@gmail.com", "dungdeptrai", "Nam Định"));
	}
	
	//Hàm chuyển chữ tiếng việt có dấu sang không dấu
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
	public UsersDto getUserDtoById(String id) {
		// TODO Auto-generated method stub
		for(Users user: users) {
			if(user.getId().equals(id)) {
				return UserMapper.toUserDto(user);
			}
		}
		throw new NotFoundException("User không tồn tại trong hệ thống");
	}
	
	@Override
	public List<UsersDto> searchUserByName(String name) {
		List<UsersDto> result = new ArrayList<UsersDto>();
		for(Users user : users) {
			if(deAccent(user.getFullName().toLowerCase()).contains(deAccent(name.toLowerCase()))) {
				result.add(UserMapper.toUserDto(user));
			}
		}
		if(result.isEmpty()) {
			throw new NotFoundException("Không có ai tên đó đâu má");
		}else {
			return result;
		}
	}

	@Override
	public Users createUser(Users user) {
	    users.add(user);
	    return user;
	}

	private boolean isEmail(String input) {
	    return input.contains("@") && input.contains(".");
	}
	
	@Override
	public Users updateUser(UserRequest user) {
		// TODO Auto-generated method stub
		for (Users u : users) {
	        if (u.getId().equals(user.getId())) {
	        	if(user.getFullName() == null) {
	        		user.setFullName(u.getFullName());
	        	} else {
	        		u.setFullName(user.getFullName());
	        	} 
	        	
	        	if(user.getDateOfBirth() == null) {
	        		user.setDateOfBirth(u.getDateOfBirth());
	        	} else {
	        		u.setDateOfBirth(user.getDateOfBirth());
	        	}
	        	
	        	if(user.getContact() != null) {
	        		if(isEmail(user.getContact())) {
		            	u.setEmail(user.getContact());
		    	    } else {
		    	    	try {
		    	    		u.setPhoneNumber(Integer.parseInt(user.getContact()));
		    	        } catch (NumberFormatException e) {
		    	            System.out.println("Không thể chuyển chỗi contact sang dạng số điện thoại");
		    	        }
		    	    }
	        	}
	        	
	        	if(!(user.getAddress().isEmpty())) {
	        		u.setAddress(user.getAddress());
	        	}
	        	
	            System.out.println("pass của "+ u.getId() + " " + u.getPassword());
	            return u;
	        }
	    }
		throw new NotFoundException("User không tồn tại trong hệ thống");
	}

	@Override
	public Users getUserById(String id) {
		// TODO Auto-generated method stub
		for(Users user: users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		throw new NotFoundException("User không tồn tại trong hệ thống");
	}
}