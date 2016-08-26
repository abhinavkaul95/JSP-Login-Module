package com.training.utils;

import java.sql.*;
import java.util.*;

import com.training.model.User;
import com.training.ifaces.InterfaceMyDAO;

public class UserDAO implements InterfaceMyDAO<User>{
private Connection conn = null;

/** No-arg constructor.
 * 
 */

public UserDAO() {
super();
conn = MySQLConnection.getMyOracleConnection();
}

/**Parameterized Constructor.
 * 
 * @param conn Connection
 */

public UserDAO(Connection conn) {
	super();
	this.conn = conn;
}

/** Add a user.
 * 
 * @param user User
 */

@Override
public int add(User user) {
int rowAdded = 0;
String sql = "insert into users values(?,?,?)";
PreparedStatement pstmt;
try {
pstmt = conn.prepareStatement(sql);
pstmt.setLong(1, user.getUserId());
pstmt.setString(2, user.getUsername());
pstmt.setString(3, user.getPassword());
rowAdded = pstmt.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
return rowAdded;
}

/** Update an entry.
 * 
 * @param userId User ID
 * @param username Username
 * @param password Password
 */

@Override
public int update(long userId, String username, String password) {
int rowUpdated = 0;
String sql = "update users set username=?,password=? where userId = " + userId;
PreparedStatement pstmt;
try {
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, username);
pstmt.setString(2, password);
rowUpdated = pstmt.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
return rowUpdated;
}

/** Find a user.
 * 
 * @param userId User ID
 */

@Override
public User find(long userId) {
String sql = "select * from users where userId = " + userId;
PreparedStatement pstmt;
ResultSet rs;
String username = null, password = null;
try {
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery(sql);
while(rs.next()){
username = rs.getString("username");
password = rs.getString("password");
}
} catch (SQLException e) {
e.printStackTrace();
}
return new User(userId, username, password);
}

/**
 * 
 */

public String find(String username) {
String sql = "select password from users where username = '" + username + "'";
PreparedStatement pstmt;
ResultSet rs;
String password = "";
try {
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery(sql);
while(rs.next()){
password = rs.getString("password");
}
} catch (SQLException e) {
e.printStackTrace();
}
return password;
}

/** Delete a user record.
 * 
 * @param userId User ID
 */

@Override
public int delete(long userId) {
int result = 0;
CallableStatement callstmt;
try {
callstmt = conn.prepareCall("{call delete_user_record(?)}");
callstmt.setLong(1,userId);
result = callstmt.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
return result;
}

/** Finds all users.
 * 
 */

@Override
public List<User> findAll() {
long userId = 0;
List<User> list = new ArrayList<User>();
String sql = "select * from users";
PreparedStatement pstmt;
ResultSet rs;
String username = null, password = null;
try {
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery(sql);
while(rs.next()){
userId = rs.getLong("userId");
username = rs.getString("username");
password = rs.getString("password");
list.add(new User(userId, username, password));
}
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}

/** Closes the connection.
 * 
 */

@Override
public void close() {
try {
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
