package com.strip.user.server;

import java.beans.JavaBean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import com.strip.sample.User_details_Request_model;
import com.strip.sample.User_model;
import com.strip.test.User;



public interface User_Service {

	
	User_model createuser(User_details_Request_model model_req);

	
	
	User_details_Request_model  retriveuser(String string, User_details_Request_model mode_req);
	
	
	
	User download_api(String url, String column, User user);
	

}
