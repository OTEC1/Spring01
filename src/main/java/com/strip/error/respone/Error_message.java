package com.strip.error.respone;

import java.util.Date;

public class Error_message {

	private Date time_Stamp;
	private String message;
	
	
	public Error_message() {}
	
   
    
	
	public Error_message(Date time_Stamp, String message) {
		super();
		this.time_Stamp = time_Stamp;
		this.message = message;
	}




	public Date getTime_Stamp() {
		return time_Stamp;
	}

	public void setTime_Stamp(Date time_Stamp) {
		this.time_Stamp = time_Stamp;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
