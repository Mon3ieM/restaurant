package com.restaurant.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.model.eo.Users;
import com.restaurant.model.repository.UsersRepository;

@Transactional
@Service
public class UsersService {

	@Autowired
	UsersRepository repo;

	
	
	
	public Users findByUsernameAndPassword(String username , String password) {
		return repo.findByUsernameAndPassword(username, password);
	}
	
	public List<Users> findByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return repo.findByRoleId(roleId);
	}
	
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void save(Users eo) {
		// TODO Auto-generated method stub
		repo.save(eo);
	}

	public Users get(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}
}

