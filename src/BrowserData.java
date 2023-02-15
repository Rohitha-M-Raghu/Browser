import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

import org.json.JSONArray;


class BrowserClass {
	protected static String[] browserName = new String[5] ;
	protected static int browserNumber = 0;
	protected static String[] browserVersion = new String[5];
	
	private JSONArray browserHistory = new JSONArray(); //history data
	
	
	public BrowserClass() {	//creating new browser history
		System.out.println("Browser Ready!!!");
	}
	
	public void addNewHistory(String url, String ip) {
		JSONArray history = new JSONArray(); 
		history.put(url);
		history.put(ip);
		Timestamp accessTime = Timestamp.from(Instant.now());
		history.put(accessTime);
		this.browserHistory.put(history);
	}
	
	public static void addBrowser(String browser, String version) {
		for(int i=0; i<BrowserClass.browserNumber; ++i) {
			if(BrowserClass.browserName[i].equals(browser)) {
				System.out.println("The browser already exists...");
				return;
			}
		}
		BrowserClass.browserName[BrowserClass.browserNumber] = browser;
		BrowserClass.browserVersion[BrowserClass.browserNumber] = version;
		BrowserClass.browserNumber ++;
		System.out.println(browser + " added Successfully... ");
	}

	public String accessBrowserData() {
		return this.browserHistory.toString();
	}
	
	public static void displayBrowsers() {
		for(int i=0; i<BrowserClass.browserNumber; ++i) {
			System.out.println(BrowserClass.browserName[i] + "\t" + BrowserClass.browserVersion[i]);
		}
	}
	
	public void removeHistory() {	//------------>TODO
		System.out.println("History removed...");
	}
	
	public void resetHistory() {
		while(this.browserHistory.length()>0) {
			this.browserHistory.remove(0);
		}
		System.out.println("Reset History!!!");
	}
	
}

public class BrowserData {
	protected static Scanner scanner = new Scanner(System.in);
	protected static BrowserClass[] Browser = new BrowserClass[5];
	public static void main(String[] args) {
		int choice = 0;
		
		while(choice != 5) {
			System.out.println("\nMAIN MENU");
			System.out.println("======================");
			System.out.println("1. Show all browsers");
			System.out.println("2. Add new Browser");
			System.out.println("3. Remove a browser");
			System.out.println("4. Browser History");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch(choice) {
				case 1: showBrowser();
						break;
				case 2: addNewBrowser();
						break;
				case 3: removeBrowser();
						break;
				case 4: browserHistoryData();
						break;
				case 5: System.out.println("Thank you for using Our Application!!");
						break;
				default: System.out.println("Invalid Choice!!");
						break;

			}	
		}
		System.out.println("Adios.......");
		
		
	}
	private static void showBrowser() {		//case1: Display all Browsers
		if(BrowserClass.browserNumber == 0) {
			System.out.println("\nNo Browser added yet");
		}
		else {
			System.out.println("List of Browsers:");
			BrowserClass.displayBrowsers();
		}
	}
	
	private static void addNewBrowser() {  //case2: Add new Browser
		System.out.print("Enter new Browser: ");
		String name = scanner.next();
		System.out.print("Enter Version: ");
		String version = scanner.next();
		BrowserClass.addBrowser(name, version);
	}
	
	private static void removeBrowser() {	//case3: Remove a Browser -------->TODO
		System.out.println("Browser Removed!!!");
	}
	
	private static void browserHistoryData() { //case4: Browser History
		int index = 0;
		int flag = 0;
		System.out.println("Select a Browser: ");
		BrowserClass.displayBrowsers();
		String name = scanner.next();
		for(int i=0; i<BrowserClass.browserNumber; ++i) {
			if (name.equals(BrowserClass.browserName[i])) {
				index = i;
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Invalid Browser!!!");
			return;
		}
		System.out.println("1. Add New History Entry");
		System.out.println("2. Remove a History Entry");
		System.out.println("3. Reset History");
		System.out.println("4. Display History");
		
		System.out.print("Enter your Choice: ");
		int historyChoice = scanner.nextInt();
		switch(historyChoice) {
			case 1: System.out.print("\nEnter the url: ");
					String url = scanner.next();
					System.out.print("Enter the ip: ");
					String ip = scanner.next();
					Browser[index] = new BrowserClass();
					Browser[index].addNewHistory(url, ip);
					break;
			case 2: Browser[index].removeHistory();
					break;
			case 3: Browser[index].resetHistory();
					break;
			case 4: System.out.println(Browser[index].accessBrowserData());
					break;
			default: System.out.println("Invalid Input");
		}
	}
	
}