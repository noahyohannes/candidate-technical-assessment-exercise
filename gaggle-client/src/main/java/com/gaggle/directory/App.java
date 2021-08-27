package com.gaggle.directory;


import com.gaggle.directory.services.RecordServices;
import com.gaggle.view.ConsoleService;

public class App {

private static final String API_BASE_URL = "http://localhost:8080/";
    
    private static final String MENU_OPTION_EXIT = "ᴇxɪᴛ";
	private static final String MAIN_MENU_OPTION_VIEW_BALANCE = "ʟᴏᴏᴋ ᴜᴘ ᴄᴏɴᴛᴀᴄᴛ ʙʏ ɴᴀᴍᴇ";
	private static final String MAIN_MENU_OPTION_SEND_BUCKS = "ʟᴏᴏᴋ ᴜᴘ ᴄᴏɴᴛᴀᴄᴛ ʙʏ ɪᴅ";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_BALANCE, MAIN_MENU_OPTION_SEND_BUCKS, MENU_OPTION_EXIT };
	
    
    private ConsoleService console;
    

    public static void main(String[] args) {
    	App app = new App(new ConsoleService(System.in, System.out));
    	app.run();
    }

    public App(ConsoleService console) {
		this.console = console;
		
	}

	public void run() {
		banner();
		mainMenu();
	}

	private void mainMenu() {
		while(true) {
			mainMenuBanner();
			String choice = (String)console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(MAIN_MENU_OPTION_VIEW_BALANCE.equals(choice)) {
				gettingTheContactByName();
			} else if(MAIN_MENU_OPTION_SEND_BUCKS.equals(choice)) {
				getTheContactById();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}

		
	private void getTheContactById() {
			boolean stillGoing = false;
			while(!stillGoing) {
				RecordServices rs = new RecordServices(API_BASE_URL);
				rs.contactIdSearch();
				break;
			}
		
		
	}
	
	private void gettingTheContactByName() {
		boolean stillGoing = false;
		while(!stillGoing) {
			RecordServices rs = new RecordServices(API_BASE_URL);
			rs.findContactByNameInput();
			break;
		}
	
	
}


	
	private void exitProgram() {
		System.out.println("𝙋𝙧𝙤𝙜𝙧𝙖𝙢 𝙀𝙭𝙞𝙩𝙞𝙣𝙜...");		
		System.exit(0);
	}
	
	
	
	private void banner() {
		System.out.println("**************************************************************************");
		System.out.println(" \n"
				+ "░██████╗░░█████╗░░██████╗░░██████╗░██╗░░░░░███████╗  ░░░██╗░██╗░░░███╗░░\n"
				+ "██╔════╝░██╔══██╗██╔════╝░██╔════╝░██║░░░░░██╔════╝  ██████████╗░████║░░\n"
				+ "██║░░██╗░███████║██║░░██╗░██║░░██╗░██║░░░░░█████╗░░  ╚═██╔═██╔═╝██╔██║░░\n"
				+ "██║░░╚██╗██╔══██║██║░░╚██╗██║░░╚██╗██║░░░░░██╔══╝░░  ██████████╗╚═╝██║░░\n"
				+ "╚██████╔╝██║░░██║╚██████╔╝╚██████╔╝███████╗███████╗  ╚██╔═██╔══╝███████╗\n"
				+ "░╚═════╝░╚═╝░░╚═╝░╚═════╝░░╚═════╝░╚══════╝╚══════╝  ░╚═╝░╚═╝░░░╚══════╝");
		System.out.println("          ");
		
		
		
	}
	
	private void mainMenuBanner() {
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("     ");
		System.out.println("---------------------------------------------");
		System.out.println(" \n"
				+ "█▀▄▀█ ▄▀█ █ █▄░█   █▀▄▀█ █▀▀ █▄░█ █░█\n"
				+ "█░▀░█ █▀█ █ █░▀█   █░▀░█ ██▄ █░▀█ █▄█");
		System.out.println("          ");
		System.out.println("---------------------------------------------");
	}
}
