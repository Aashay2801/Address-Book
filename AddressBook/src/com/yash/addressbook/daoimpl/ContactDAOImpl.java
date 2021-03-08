package com.yash.addressbook.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.yash.addressbook.dao.ContactDAO;
import com.yash.addressbook.dbutil.DBUtil;
import com.yash.addressbook.model.Contact;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDAOImpl extends DBUtil implements ContactDAO {

	@Override
	public void saveContact(Contact contact) {
		try {
			PreparedStatement pstmt = super.createPreparedStatement("insert into contact(userId,contactName,phoneNo,address,email,contactGroup) values(?,?,?,?,?,?)");
			pstmt.setInt(1, contact.getUserId());
			pstmt.setString(2, contact.getContactName());
			pstmt.setString(3, contact.getPhoneNo());
			pstmt.setString(4, contact.getAddress());
			pstmt.setString(5, contact.getEmail());
			pstmt.setString(6, contact.getContactGroup());
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Override
	public Contact getContactById(int contactId) {
            Contact contact = new Contact();
            try {
                PreparedStatement pstmt = super.createPreparedStatement("select * from contact where contactId=?");
                pstmt.setInt(1, contactId);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                System.out.println(rs.getString("contactName"));
                contact.setUserId(rs.getInt("userId"));
                contact.setContactName(rs.getString("contactName"));
                contact.setPhoneNo(rs.getString("phoneNo"));
                contact.setAddress(rs.getString("Address"));
                contact.setEmail(rs.getString("email"));
                contact.setContactGroup(rs.getString("contactGroup"));
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ContactDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
                return contact;
	}

	@Override
	public void updateContact(Contact contact) {
            try {
                PreparedStatement pstmt = super.createPreparedStatement("update contact set contactName=?,phoneNo=?,address=?,email=?,contactGroup=? where contactId=?");
                pstmt.setString(1, contact.getContactName());
		pstmt.setString(2, contact.getPhoneNo());
		pstmt.setString(3, contact.getAddress());
		pstmt.setString(4, contact.getEmail());
		pstmt.setString(5, contact.getContactGroup());
                pstmt.setInt(6, contact.getConactId());
                System.out.println("update Called");
               pstmt.executeUpdate();
//                System.out.println(check);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	
	}

	@Override
	public void delete(int id) {
            try {
                PreparedStatement pstmt = super.createPreparedStatement("delete from contact where contactId=?");
                pstmt.setInt(1, id);
                int check = pstmt.executeUpdate();
                System.out.println(check);
            } catch (Exception ex) {
                Logger.getLogger(ContactDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
	}



	@Override
	public Vector<Vector> getAll(int userId) {
		Vector<Vector> data=new Vector();
	try {
		PreparedStatement pstmt = super.createPreparedStatement("select contactId,contactName,phoneNo,address,email,contactGroup from contact where userId='"+userId+"'");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Vector row = new Vector();
                        row.add(rs.getString("contactId"));
			row.add(rs.getString("contactName"));
			row.add(rs.getString("phoneNo"));
			row.add(rs.getString("address"));
			row.add(rs.getString("email"));
			row.add(rs.getString("contactGroup"));
			data.add(row);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return data;
	}



	@Override
	public ResultSet getAllContacts(int userId) {
		ResultSet rs = null;
			PreparedStatement pstmt;
			try {
				pstmt = super.createPreparedStatement("select contactId,contactName,phoneNo,address,email,contactGroup from contact where userId='"+userId+"'");
				rs = pstmt.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
	}

}
