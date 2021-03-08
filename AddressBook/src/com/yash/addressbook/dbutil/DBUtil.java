package com.yash.addressbook.dbutil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
		
		static final String url="jdbc:mysql://localhost:3306/addressbook";
		static final String userName="root";
		static final String password="root";
		static final String driverClassName="com.mysql.cj.jdbc.Driver";
//		static {
//			try {
//				Class.forName("com.mysql.jdbc.cj.driver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
		static Connection conn ;
		
		
		public static Connection getConnection() throws Exception {
			Class c = Class.forName(driverClassName);
//	        c.newInstance();
	        
	        conn=DriverManager.getConnection(url,userName,password);
	        return conn;
		}
		
		public PreparedStatement createPreparedStatement(String query) throws Exception{
	        try {
	            getConnection();
	            return conn.prepareStatement(query);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	           throw new RuntimeException(ex);
	        }
	    }


	    public void closePreparedStatement(PreparedStatement pst) {
	        try {
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException ex) { //silent
	        }
	    }
	    public void closeStatement(Statement st) {
	        try {
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException ex) {
	        }
	    }
	    public void closeResultSet(ResultSet rs) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException ex) {
	        }
	    }

	    public void closeConnection() {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	        }

	    }		
}
