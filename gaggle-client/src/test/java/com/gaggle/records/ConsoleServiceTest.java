package com.gaggle.records;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.gaggle.view.ConsoleService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsoleServiceTest {

	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}

	@Test
	public void displays_a_list_of_menu_options_and_prompts_user_to_make_a_choice() {
		Object[] options = new Object[] { new Integer(3), "Blind", "Mice" };
		ConsoleService console = getServiceForTesting();

		console.getChoiceFromOptions(options);

		String expected = "\n" + "1 ►" + options[0].toString() + "\n" + "2 ►" + options[1].toString() + "\n" + "3 ►"
				+ options[2].toString() + "\n\n" + "ᴘʟᴇᴀsᴇ ᴄʜᴏᴏsᴇ ᴀɴ ᴏᴘᴛɪᴏɴ → \n";
		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void returns_object_corresponding_to_user_choice() {
		Integer expected = new Integer(456);
		Integer[] options = new Integer[] { new Integer(123), expected, new Integer(789) };
		ConsoleService console = getServiceForTestingWithUserInput("2\n");

		Integer result = (Integer) console.getChoiceFromOptions(options);

		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void prints_a_blank_line_after_successful_choice() {
		Integer[] options = new Integer[] { 123, 456, 789 };
		ConsoleService console = getServiceForTestingWithUserInput("2\n");

		Integer result = (Integer) console.getChoiceFromOptions(options);

		String expected = "\n" + "1 ►" + options[0].toString() + "\n" + "2 ►" + options[1].toString() + "\n" + "3 ►"
				+ options[2].toString() + "\n\n" + "ᴘʟᴇᴀsᴇ ᴄʜᴏᴏsᴇ ᴀɴ ᴏᴘᴛɪᴏɴ → \n";
		
		Assert.assertEquals(expected, output.toString());
	}

	
	@Test
	public void displays_prompt_for_user_input() {
		ConsoleService console = getServiceForTesting();
		String prompt = "Your Name";
		String expected = "Your Name: ";
		console.getUserInput(prompt);
		Assert.assertEquals(expected, output.toString());
	}
	
	@Test
	public void returns_user_input() {
		String expected = "Juan";
		ConsoleService console = getServiceForTestingWithUserInput(expected);
		String result = console.getUserInput("Your Name");
		Assert.assertEquals(expected, result);
	}
	

	private ConsoleService getServiceForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new ConsoleService(input, output);
	}

	private ConsoleService getServiceForTesting() {
		return getServiceForTestingWithUserInput("1\n");
	}
}