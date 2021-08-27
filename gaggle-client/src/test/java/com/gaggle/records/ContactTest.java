package com.gaggle.records;
import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import com.gaggle.directory.model.Contact;

public class ContactTest {
	Contact contact = new Contact();

	@Test
	public void contactId_equal_to_5() {
		Long id = (long) 5;
		contact.setContactId(id); 
		assertEquals(contact.getContactId(), id);
	}

	@Test
	public void firstName_equals_Brian() {
		contact.setFirstName("Brian");
		assertEquals(contact.getFirstName(), "Brian");
	}
	
	@Test
	public void lastName_equals_Mericle() {
		contact.setLastName("Mericle");
		assertEquals(contact.getLastName(), "Mericle");
	}


}