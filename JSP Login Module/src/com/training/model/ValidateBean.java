/** 
 * 
 */
package com.training.model;

/* import java.util.HashMap; */

import com.training.utils.UserDAO;

/** Java Bean to validate.
 * @author akaul5
 *
 */
public class ValidateBean {
  /* private HashMap<String, String> map; */
  /**
   * User DAO implementation.
   */
  private UserDAO userdao;
  
  /** 
   * No-arg constructor.
   */
  public ValidateBean() {
    super();
    /* map = new HashMap<String, String>(); */
    userdao = new UserDAO();
  }
  
  /**
   * Initialisation function.
   */
  private void init() {
	/*
	map.put("username1", "password1");
	map.put("username2", "password2");
	map.put("username3", "password3");
	map.put("username4", "password4");
	map.put("username5", "password5");
	*/
  }
  /**
   * Validation Function.
   * @param username
   * @param password
   * @return
   */
  public boolean validate(String username, String password) {
	init();
	boolean valid = false;
	/*
	if (password.equals(map.get(username))) {
	  valid = true;
	}
	*/
	
	if(password.equals(userdao.find(username))){
		valid = true;
	}
	return valid;
  }
}
