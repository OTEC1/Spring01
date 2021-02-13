package com.strip.sample;


public class User_model {
	

		String first_name, last_name, email, user_id, phone, password;

		
		
		 public User_model() {
			// TODO Auto-generated constructor stub
		 }
		
		 
		 
		 
		public User_model(String first_name, String last_name, String email, String user_id, String phone,
				String password) {
			super();
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
			this.user_id = user_id;
			this.phone = phone;
			this.password = password;
		}
		
		
		
		

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}




		@Override
		public String toString() {
			return "User_model [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
					+ ", user_id=" + user_id + ", phone=" + phone + ", password=" + password + "]";
		}
		
		
		
		

}
