package com.dalwadibrothers.firebasedemo.model;

public class User {
   
   int user_id;
   String first_name;
   String last_name;
   String zip_code;
   
   public User(int user_id, String first_name, String last_name, String zip_code) {
      this.user_id = user_id;
      this.first_name = first_name;
      this.last_name = last_name;
      this.zip_code = zip_code;
   }
   
   public int getUser_id() {
      return user_id;
   }
   
   public void setUser_id(int user_id) {
      this.user_id = user_id;
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
   
   public String getZip_code() {
      return zip_code;
   }
   
   public void setZip_code(String zip_code) {
      this.zip_code = zip_code;
   }
}
