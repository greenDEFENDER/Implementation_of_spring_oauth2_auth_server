package com.example.authorizationserver.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.authorizationserver.model.User;

//dummy repository class for getting  an user bean
@Repository
public class Repo {

	public UserDetails findUser(String userName) {
		List<User> users = Arrays.asList(new User("abhay", "USER"), new User("uday", "ADMIN"));
		User targetUser = null;
		for (User user : users) {
			if (user.getUsername().equals(userName)) {
				targetUser = user;
				break;
			}

		}

		return targetUser;
	}
}
