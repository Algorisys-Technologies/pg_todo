package com.todo.demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.demo.config.JwtTokenUtil;
import com.todo.demo.model.User;
import com.todo.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public Map<String, Object> login(String email, String password) throws Exception {
		User user = userRepo.login(email, password).orElseThrow(ArithmeticException::new);
		String token = jwtTokenUtil.generateToken(user);

		Map<String, Object> details = new HashMap<String,Object>();
		details.put("accessToken", token);
		details.put("name", user.getName());
		details.put("email", user.getEmail());
		details.put("id", user.getId());
		details.put("collegename", user.getCollegeName());
		return details;
	}

	public User register(User userRegister) {
		return userRepo.save(userRegister);
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
