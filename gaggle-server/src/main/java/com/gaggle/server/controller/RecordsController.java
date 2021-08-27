package com.gaggle.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaggle.server.dao.RecordsDAO;
import com.gaggle.server.model.Contact;


@RestController
public class RecordsController {
	
	@Autowired
	private RecordsDAO recordsDAO;
	
	public RecordsController(RecordsDAO recordsDAO) {
		this.recordsDAO = recordsDAO;
	}

	
	@RequestMapping(path = "listcontacts", method = RequestMethod.GET)
	public List <Contact> listContacts() {
		List <Contact> contacts = recordsDAO.findAll();
		return contacts;
	}
	
	
	@RequestMapping(path = "contacts/{id}", method = RequestMethod.GET)
	public Contact getSelectedContact(@PathVariable Long id) {
		Contact contact = recordsDAO.getContactById(id);
		return contact;
	}
}
