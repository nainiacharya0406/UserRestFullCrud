package com.main.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	//retrieve all user
	@GetMapping(path = "/retriveAll")
	public List<User> retrieve() {
		return service.findAll();
	} 

	//retrieve User
	@GetMapping(path="user/{id}")
	public Resource<User> singleUser(@PathVariable int id) {
		User user = service.findUser(id);
		if(user == null) {
			throw new UserNotFoundException("id :"+id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).retrieve());
		resource.add(link.withRel("get-all-user"));
		return resource;
	}

	//create user
	@PostMapping(path = "/user")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();	
		 
	}
	
	//delete user
		@DeleteMapping(path = "user/{id}")
		public void deleteUser(@PathVariable int id) {
			User user = service.deleteUser(id);
			if(user == null) {
				throw new UserNotFoundException("id :"+id);
			}
			 
		}
}
