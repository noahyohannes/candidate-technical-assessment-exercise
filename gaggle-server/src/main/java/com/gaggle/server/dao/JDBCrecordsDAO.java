package com.gaggle.server.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.gaggle.server.model.Contact;

import java.util.ArrayList;


@Component
public class JDBCrecordsDAO implements RecordsDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCrecordsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	

	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT contact_id, first_name, last_name FROM contact;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Contact contact = mapRowToContact(results);
            contacts.add(contact);
        }
        return contacts;
		
	}
	
	


	@Override
	public Contact getContactById(Long contactId) {
		Contact contact = new Contact();
		String sql = "SELECT * FROM contact WHERE contact_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, contactId);
		
		if (results.next()) {
			contact = mapRowToContact(results);
		}
		return contact;
	}

	
	private Contact mapRowToContact(SqlRowSet rs) {
        
		Contact contact = new Contact();
        contact.setContactId(rs.getLong("contact_id"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        
        
        return contact;
    }


}

