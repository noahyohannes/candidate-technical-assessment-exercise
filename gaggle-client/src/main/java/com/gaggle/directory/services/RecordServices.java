package com.gaggle.directory.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.gaggle.directory.model.Contact;

public class RecordServices {

	private String BASE_URL;
	private RestTemplate restTemplate = new RestTemplate();

	public RecordServices(String url) {
		BASE_URL = url;
	}


	public Contact[] contactIdSearch() {
		Contact[] output = null; // Create an empty Contact array to populate existing names from database.

		try {
			output = restTemplate.exchange(BASE_URL + "listcontacts", HttpMethod.GET, makeAuthEntity(), Contact[].class)
					.getBody(); // GET call that retrieves info from database and stores it in "output".

			System.out.print("-------------------------------------------\r\n"
					+ "𝙋𝙡𝙚𝙖𝙨𝙚 𝙚𝙣𝙩𝙚𝙧 𝙘𝙤𝙣𝙩𝙖𝙘𝙩 𝙄𝘿 𝙩𝙤 𝙫𝙞𝙚𝙬 𝙙𝙚𝙩𝙖𝙞𝙡𝙨 (0 𝙩𝙤 𝙘𝙖𝙣𝙘𝙚𝙡): ");                                       
		

			Scanner scanner = new Scanner(System.in); // Creates a new scanner object for user input
			String input = scanner.nextLine(); // Store users input and stores it as a string in "input"

			if (Integer.parseInt(input) != 0) { // If user input is 0, then program method is ended.

				boolean foundContactId = false; // Declare this variable to determine later if the ID was not found.

				for (Contact i : output) { // For each loop to traverse output array of contacts from database

					if (Integer.parseInt(input) == i.getContactId()) { // If Contact Id matches any Id found in the
																		// "output" array

						Contact temp = restTemplate.exchange(BASE_URL + "contacts/" + i.getContactId(), HttpMethod.GET,
								makeAuthEntity(), Contact.class).getBody(); // perform a GET call using the confirmed Id

						foundContactId = true; // Set this to true to affirm it has been found and populated in our
												
						
						contactResult(temp); // temporary Contact object to print
					
					}
				}
				if (!foundContactId) { // In the event a non-existing ID is entered, the following occurs.
					System.out.println("");
					System.out.println("𝙲𝚘𝚗𝚝𝚊𝚌𝚝 𝚍𝚘𝚎𝚜 𝚗𝚘𝚝 𝚎𝚡𝚒𝚜𝚝. 𝚁𝚎𝚝𝚞𝚛𝚗𝚒𝚗𝚐 𝚝𝚘 𝙼𝚊𝚒𝚗 𝙼𝚎𝚗𝚞. 𝙿𝚕𝚎𝚊𝚜𝚎 𝚝𝚛𝚢 𝚊𝚐𝚊𝚒𝚗.");
				}
			}

		} catch (Exception e) { //If an integer is entered, then following is printed.
			System.out.println("𝙴𝚛𝚛𝚘𝚛 - 𝙸𝚗𝚟𝚊𝚕𝚒𝚍 𝙸𝚗𝚙𝚞𝚝. 𝚁𝚎𝚝𝚞𝚛𝚗𝚒𝚗𝚐 𝚝𝚘 𝙼𝚊𝚒𝚗 𝙼𝚎𝚗𝚞. 𝙿𝚕𝚎𝚊𝚜𝚎 𝚝𝚛𝚢 𝚊𝚐𝚊𝚒𝚗.");
		}
		return output;
	}


	public Contact[] findContactByNameInput() {
		Contact[] contact = null; // Declare an empty Contacts array to populate names from directory
		System.out.print("𝙋𝙡𝙚𝙖𝙨𝙚 𝙀𝙣𝙩𝙚𝙧 𝙉𝙖𝙢𝙚 𝙤𝙛 𝙩𝙝𝙚 𝙘𝙤𝙣𝙩𝙖𝙘𝙩: (𝙀 𝙩𝙤 𝙘𝙖𝙣𝙘𝙚𝙡): ");
		Scanner scanner = new Scanner(System.in); // Creates a new scanner object for user input.
		String rawInput = scanner.nextLine(); // Store users input and stores it as a string in "input".
		
		try{
			  Integer.parseInt(rawInput);
			  	System.out.println("𝙴𝚛𝚛𝚘𝚛 - 𝙸𝚗𝚟𝚊𝚕𝚒𝚍 𝙸𝚗𝚙𝚞𝚝. 𝚁𝚎𝚝𝚞𝚛𝚗𝚒𝚗𝚐 𝚝𝚘 𝙼𝚊𝚒𝚗 𝙼𝚎𝚗𝚞. 𝙿𝚕𝚎𝚊𝚜𝚎 𝚝𝚛𝚢 𝚊𝚐𝚊𝚒𝚗. ");
			  	System.out.println("     ");
			  	System.out.println("     ");
			  	System.out.println("     ");
			} catch(NumberFormatException ex){
				contact = restTemplate
				.exchange(BASE_URL + "listcontacts", HttpMethod.GET, makeAuthEntity(), Contact[].class).getBody(); //GET call that retrieves info from database and stores it in "output".
		
		
		boolean foundContactName = false; // Declare this variable to determine later if the ID was not found.
		
		
		if(!rawInput.contains("e")) { // If user input is e, then program method is ended.
			
			String input = rawInput.toUpperCase(); //Takes the user's input & sets all character to upper case for later comparison.

			ArrayList<Contact> tempListOfContacts = new ArrayList<Contact>();// Declare a temporary list of contacts which will hold matches that agree user's search criteria.

			
			for (Contact i : contact) { //Iterates through each contact object that was populated earlier.

				if (i.getFirstName().toUpperCase().contains(input) || i.getLastName().toUpperCase().contains(input)) { // If the input when upper cased exist either within the First OR Last name of the contact object at hand.

					foundContactName = true; // Then set this to true to affirm it has been found and populated in our temporary lists of Contact objects to print.

					
					tempListOfContacts.add(i); // And add that Contact object to our temporary list for printing later

				} 
			
			}
			String list = Arrays.toString(tempListOfContacts.toArray()).replace("[", "").replace("]", "").replace(",", ""); //Store tempListOfContacts as a String.
			if(list.isEmpty()) { //If string is empty
				System.out.println("");
				System.out.println("𝙴𝚖𝚙𝚝𝚢 𝚛𝚎𝚜𝚞𝚕𝚝, 𝚙𝚕𝚎𝚊𝚜𝚎 𝚝𝚛𝚢 𝚊𝚐𝚊𝚒𝚗.");
			} else {
				resultsPrinter(list); // Passes new string in this method for formatted printing.
			}
			
			
		} else if (!foundContactName) { //If boolean was never set to true, the print the following
			System.out.println("𝙲𝚘𝚗𝚝𝚊𝚌𝚝 𝚍𝚘𝚎𝚜 𝚗𝚘𝚝 𝚎𝚡𝚒𝚜𝚝. 𝚁𝚎𝚝𝚞𝚛𝚗𝚒𝚗𝚐 𝚝𝚘 𝙼𝚊𝚒𝚗 𝙼𝚎𝚗𝚞. 𝙿𝚕𝚎𝚊𝚜𝚎 𝚝𝚛𝚢 𝚊𝚐𝚊𝚒𝚗. ");
		}
		
		
			}
		return contact;
	}
	

	
	
	
	private HttpEntity makeAuthEntity() {
		HttpHeaders headers = new HttpHeaders();

		HttpEntity entity = new HttpEntity<>(headers);
		return entity;
	}
	
	
	
	
	
	private void resultsPrinter(String listOfResults) {
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\r\n" + "●       𝗥 𝗘 𝗦 𝗨 𝗟 𝗧 𝗦       ●\r\n"
				+ "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\r\n");
		System.out.println(listOfResults); // Print our temporary list of Contacts
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("     ");
	}
	
	private void contactResult(Contact contactFoundById) {
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\r\n" + "● ＣＯＮＴＡＣＴ  ＤＥＴＡＩＬＳ ●\r\n"
				+ "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\r\n");
		System.out.println("     ");
		System.out.println(
				"      𝙄𝘿: " + contactFoundById.getContactId()
				+ "\r\n" + "      𝙁𝙞𝙧𝙨𝙩 𝙉𝙖𝙢𝙚: " + contactFoundById.getFirstName() + "\r\n" + "      𝙇𝙖𝙨𝙩 𝙉𝙖𝙢𝙚: "
				+ contactFoundById.getLastName());
	}
	
}
