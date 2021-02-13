package com.strip.user.server.implementation;

import java.security.CryptoPrimitive;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Base64;
import com.strip.sample.User_details_Request_model;
import com.strip.sample.User_model;
import com.strip.shared.Utils;
import com.strip.test.User;
import com.strip.user.server.User_Service;

@Service
public class UserServiceImpl  implements User_Service{
	
	Map<String, User_model> users;
	Utils utils;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils=utils;
	}
	
	
	public UserServiceImpl() {
		
	}
	
	
	@Override
	public User_model createuser(User_details_Request_model model_req) {
		
		User_model  model=new User_model();
		model.setEmail(model_req.getEmail());
		model.setFirst_name(model_req.getFirst_name());
		model.setLast_name(model_req.getLast_name());
		model.setPhone(model_req.getPhone());
		model.setPassword(model_req.getPassword());
		
		
		String string=utils.generateUserid();
		model.setUser_id(string);
		
		if(users==null)
			users=new HashMap<>();
		
		 member_register(string, model.getFirst_name(), model.getLast_name(),model.getEmail(), model.getPhone(), model.getPassword());	
		users.put(string, model);
			return model;
	
	}
	
	
	private void member_register(String user_id, String first_name, String last_name,String email, String phone, String password ) {
	    String sql = "INSERT INTO testing321  (first_name, last_name,email,phone,password,user_id) VALUES (?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql, first_name,last_name,email,phone,password,user_id);
         
        if (result > 0) {
            System.out.println("Insert successfully.");
        }      	
	}


	
	
	@Override
	public User_details_Request_model retriveuser(String name, User_details_Request_model mode_req) {

		
		//Named Parameter Query String  Optional insert parameter
		  
		  NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(datasource);
		  SqlParameterSource param = new MapSqlParameterSource("user_id", name);
		   template.query("SELECT * from  testing321 m where m.user_id = :user_id",param, new ResultSetExtractor<User_details_Request_model>(){

			@Override
			public User_details_Request_model extractData(ResultSet rs) throws SQLException, DataAccessException {

				if(rs.next()) {
					mode_req.setFirst_name(rs.getString("first_name"));
					mode_req.setLast_name(rs.getString("last_name"));
					mode_req.setEmail(rs.getString("Email"));
					mode_req.setPhone(rs.getString("phone"));
					mode_req.setUser_id(rs.getString("user_id"));
					
				}
		       return null;
			}});
		return mode_req;}
	
		  
	    /*Positioned Parameter Query String 
	     @Query(value="select * from  testing321 m where m.last_name = ?1 ", nativeQuery = true)
	     List<User_model> find_user_by_name1(@Param("last_name") String name1) {
		 return null; 
	    }*/

	
	

		@Override
		public User download_api(String url, String column, User user) {
			// TODO Auto-generated method stub
			return null;
		}
	     
		
		
		
			

		
	
	

		  }
