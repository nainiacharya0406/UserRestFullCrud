package com.main.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount =2;

	static {
		users.add(new User(1, "naini", new Date()));
		users.add(new User(2, "suguna", new Date()));
	}

	//findAll
	public List<User> findAll(){
		return users;
	}

	//saveUser
	public User saveUser(User user) {

		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}


	//find specific user

	public User findUser(int id) {

		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	//Delete User 
	public User deleteUser(int id) {
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getId() == id) {
				itr.remove();
				return user;
			}
		}		
		return null;
	}
}
