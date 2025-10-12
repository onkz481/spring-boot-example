package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// 全ユーザー取得
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	// 1ユーザー登録
	public User createUser(String name, String email) {
		User user = new User(name, email);
		
		return userRepository.save(user);
	}
	
	// Email検索
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
