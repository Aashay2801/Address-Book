package com.yash.addressbook.service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.yash.addressbook.model.Contact;

public interface ContactService {

	public void save(Contact contact);
	public Vector<Vector> getAll(int userId);
	public Contact getContactById(int contactId);
	public void update(Contact contact);
	public void delete(int id);
	public ResultSet getallContacts(int userId);
}
