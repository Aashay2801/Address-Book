package com.yash.addressbook.serviceimpl;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.yash.addressbook.daoimpl.ContactDAOImpl;
import com.yash.addressbook.model.Contact;
import com.yash.addressbook.service.ContactService;

public class ContactServiceImpl implements ContactService {
	
	ContactDAOImpl contactDao = new ContactDAOImpl();
	@Override
	public void save(Contact contact) {
		contactDao.saveContact(contact);

	}

	@Override
	public Vector<Vector> getAll(int userId) {
		return contactDao.getAll(userId);
		
	}

	@Override
	public Contact getContactById(int contactId) {
		
		return contactDao.getContactById(contactId);
	}

	@Override
	public void update(Contact contact) {
         contactDao.updateContact(contact);
	}

	@Override
	public void delete(int id) {
		contactDao.delete(id);

	}

	@Override
	public ResultSet getallContacts(int userId) {
		
		return contactDao.getAllContacts(userId);
	}

}
