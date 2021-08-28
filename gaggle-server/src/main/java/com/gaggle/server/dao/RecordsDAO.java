package com.gaggle.server.dao;

import java.util.List;

import com.gaggle.server.model.Contact;

public interface RecordsDAO {

	List<Contact> findAll();
	
	public Contact getContactById(Long contactId);

}

