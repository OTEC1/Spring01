package com.strip.sample;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strip.user.server.User_Service;
import com.strip.user.server.implementation.UserServiceImpl;
import com.strip.test.DES;
import com.strip.test.User;
@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "*")
public class UserController {

	
	Map<String, Object> users;
	
	@Autowired
	User_Service userService;
	
	
	
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page"  , defaultValue = "1") int page, 
	  @RequestParam(value = "limit", defaultValue = "50") int limit,
	  @RequestParam(value = "sort", defaultValue = "desc", required = false)String sort){
		
		return  "get users was Called  page= "+page+" and limit= "+limit;
	}
	

	
	@SuppressWarnings("unchecked")
	@GetMapping(path="{userId}"/*,produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}*/)
	public ResponseEntity<User_model> getUser(@PathVariable String userId) { //if(true) throw new User_service_exception("User Service exception throw");
		if(users.containsKey(userId))
			return new  ResponseEntity(users.get(userId),HttpStatus.OK);
		else
		     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	}
	
	
	

	@GetMapping(path="/zt"  /*,produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}*/)
	@CrossOrigin(origins = "*")
	public ResponseEntity<User_details_Request_model> getParticular(@RequestParam(value = "token") String token, @RequestParam(value = "column") String column, User_details_Request_model model_req) { //if(true) throw new User_service_exception("User Service exception throw");
		boolean matchs = true;
		if(matchs) {
			User_details_Request_model retModel =userService.retriveuser(token,model_req);
			return new  ResponseEntity<>(retModel,HttpStatus.OK);
		}
		else
		     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	}
	
	
	
	
	@PostMapping( /*consumes  = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},	produces = {MediaType.APPLICATION_XML_VALUE,    MediaType.APPLICATION_JSON_VALUE}*/)
	public ResponseEntity<User_model> createUser(@RequestBody User_details_Request_model model_req) {
		 User_model retModel =userService.createuser(model_req);
		return new ResponseEntity<User_model>(retModel, HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping(path="/IlL")
	@CrossOrigin(origins = "*")
	public ResponseEntity<User> getPublicKey(@RequestParam(value = "token") String token, @RequestParam(value = "column") String column, User models){
		
		User user = null; //= userService.download_api(token, column, models);
		
		System.out.println(token +" and  " +column); //can accept list of hashes
		
		 System.out.println(new DES().generateRsakeyPair(column));
		return null;
	}
	







	



	@PutMapping(path="/{userId}",
		consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public User_model updateUser(@PathVariable String userid,  @RequestBody UpdateUserDetailsRequestModel url) {
		
		User_model store_user= (User_model) users.get(userid);
		store_user.setFirst_name(url.getFirstName());
		store_user.setLast_name(url.getLastName());
		
		users.put(userid, store_user);
	return store_user;
	}
	
	
	
	
	
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return  ResponseEntity.noContent().build();
	}
	
	
	
	

}
