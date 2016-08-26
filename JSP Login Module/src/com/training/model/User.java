/**
 * 
 */
package com.training.model;

/**
 * @author abhinavkaul
 *
 */
public class User {
private long userId;
private String username;
private String password;
/**
 * 
 * @param username
 * @param password
 */
public User(long userId, String username, String password) {
	super();
	this.userId = userId;
	this.username = username;
	this.password = password;
}
/**
 * 
 */
public User() {
	super();
}

/**
 * @return the userid
 */
public long getUserId() {
	return userId;
}
/**
 * @param userid the userid to set
 */
public void setUserId(long userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

/** String representation of the User object.
 * 
 */

@Override
public String toString() {
	return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */

/** Calculates the hash code.
 * 
 */

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + (int) (userId ^ (userId >>> 32));
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */

/** Equal User objects.
 * 
 * @param obj Object
 */

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (userId != other.userId)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}



}
