package com.kh.mcdonalds.model.service;

import java.util.List;

import com.kh.mcdonalds.model.dao.UserDAO;
import com.kh.mcdonalds.model.dto.UserDTO;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public List<UserDTO> findAll(){
		return userDao.findAll();
	}
}
