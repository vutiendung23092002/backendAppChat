package com.huce51565.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huce51565.entity.Users;
import com.huce51565.modal.dto.UsersDto;
import com.huce51565.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("")
	public ResponseEntity<?> getListUsers(){
		List<UsersDto> users = userService.getListUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id){
		UsersDto user = userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchUserByName(@RequestParam(name="keyword",required = false, defaultValue="" ) String name) {
		List<UsersDto> users = userService.searchUserByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("")
	public ResponseEntity<?> creatUser(){
		Users user = new Users("dung2309", "Vũ Tiến Dũng", "0896011465", "51565239", "Kim Đồng" );
		return ResponseEntity.status(HttpStatus.OK).body(user);
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(){
		Users user = new Users("dung2309", "Vũ Tiến Dũng", "0896011465", "51565239", "Kim Đồng" );
		return ResponseEntity.status(HttpStatus.OK).body(user);
		//test
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(){
		Users user = new Users("dung2309", "Vũ Tiến Dũng", "0896011465", "51565239", "Kim Đồng" );
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
