package com.thomas.bookster.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.bookster.models.User;
import com.thomas.bookster.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User findOneUser(Long id ) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> getAllUsers() {
		return this.uRepo.findAll();
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}

	public UserRepository getuRepo() {
		return uRepo;
	}

	public void setuRepo(UserRepository uRepo) {
		this.uRepo = uRepo;
	}


}

