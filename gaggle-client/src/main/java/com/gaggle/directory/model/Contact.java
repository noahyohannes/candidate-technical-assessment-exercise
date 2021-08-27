package com.gaggle.directory.model;

public class Contact {
	
	private Long contactId;
	private String firstName;
	private String lastName;
	
	public Contact() {}
	
	public Contact(Long contactId, String firstName, String lastName) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "   \r\n" + "      𝙄𝘿: " + contactId
				+ "\r\n" + "      𝙁𝙞𝙧𝙨𝙩 𝙉𝙖𝙢𝙚: " + firstName + "\r\n" + "      𝙇𝙖𝙨𝙩 𝙉𝙖𝙢𝙚: "
				+ lastName + "\r\n"
				+ "  \r\n";
	}

}

