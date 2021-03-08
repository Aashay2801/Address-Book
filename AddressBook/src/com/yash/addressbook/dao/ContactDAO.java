package com.yash.addressbook.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.yash.addressbook.model.Contact;

public interface ContactDAO {
	
	public void saveContact(Contact contact);
	public Vector<Vector> getAll(int userId);
	public Contact getContactById(int contactId);
	public void updateContact(Contact contact);
	public void delete(int id);
	public ResultSet getAllContacts(int userId);
}
