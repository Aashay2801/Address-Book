package com.yash.addressbook.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yash.addressbook.dao.UserDao;
import com.yash.addressbook.dbutil.DBUtil;
import com.yash.addressbook.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl extends DBUtil implements UserDao {

//	DBUtil dbUtil ;
//	public public UserDAOImpl() {
//		dbUtil = new DBUtil();
//	}
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
            User user = new User();
            try {
                
                PreparedStatement pstmt = super.createPreparedStatement("select * from user where userId="+userId);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    user.setUserName(rs.getString("userName"));
                    user.setPhoneNo(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                }
                
            } catch (Exception ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
             return user;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
            try {
                PreparedStatement pstmt = super.createPreparedStatement("update user set userName=?,phone=?,address=?,email=? where userId=?");
                pstmt.setString(1, user.getUserName());
                pstmt.setString(2, user.getPhoneNo());
                pstmt.setString(3, user.getAddress());
                pstmt.setString(4, user.getEmail());
                pstmt.setInt(5, user.getUserId());
                int check = pstmt.executeUpdate();
                System.out.println(check);
            } catch (Exception ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
                

	}

	@Override
	public User authenticateUser(String userName, String password) throws Exception{
		
			PreparedStatement pstmt = super.createPreparedStatement("select * from user where userName='"+userName+"'and password='"+password+"'");
//			pstmt.setString(1, userName);
//			pstmt.setString(2, password);
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()) {
				int userId= rs.getInt("userId");
				User user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				return user;
			}else {
				throw new RuntimeException("Please Provide Valid User Name or Password");
			}
		
		
	}

}
