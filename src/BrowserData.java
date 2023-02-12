import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

import org.json.JSONArray;

class BrowserClass {
	private String browserName = "";
	
	private JSONArray browserHistory = new JSONArray(); //history data
	
	
	public BrowserClass(String name) {	//creating new browser history
		this.browserName = name;
	}
	
	public void addBrowserData(String url, String ip) {
		JSONArray history = new JSONArray(); 
		history.put(url);
		history.put(ip);
		Timestamp accessTime = Timestamp.from(Instant.now());
		history.put(accessTime);
		this.browserHistory.put(history);
	}

	public String accessBrowserData() {
		//for(int i=0;i<history.length(); ++i) {
		//	history.optJSONArray(i);
		//}
		return this.browserHistory.toString();
	}
	

	
}



public class BrowserData {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputUrl = new String();
		char ch = 'y';
		int choice;
		String browserChoice = new String();
		BrowserClass chrome = new BrowserClass("chrome");
		BrowserClass firefox = new BrowserClass("firefox");
		do {
			System.out.println("CHOOSE:");
			System.out.println("======================");
			System.out.println("1. Add new url");
			System.out.println("2. Display history");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch(choice) {
				case 1: System.out.print("\nEnter the browser: ");
						browserChoice = scanner.next();
						System.out.print("\nEnter the url: ");
						inputUrl = scanner.next();
						System.out.print("\nEnter the ip: ");
						String ip = scanner.next();
						if (browserChoice.equals("firefox")) {
							firefox.addBrowserData(inputUrl, ip);
						}
						else {
							chrome.addBrowserData(inputUrl, ip);
						}
						break;
				case 2: System.out.print("\nEnter the browser: ");
						browserChoice = scanner.next();
						if (browserChoice.equals("firefox")) {
							String browserData = firefox.accessBrowserData();
							System.out.println(browserData);
							//browserHistory = Arrays.copyOf(firefox.accessHistory(), 10);
							//for(int i=0;i<firefox.accessHistorySize();++i) {
							//	System.out.println("\n" + browserHistory[i]);
							//}
						
						}
						else {
							String browserData = chrome.accessBrowserData();
							System.out.println(browserData);
							//browserHistory = Arrays.copyOf(chrome.accessHistory(), 10);
							//for(int i=0;i<chrome.accessHistorySize();++i) {
							//	System.out.println("\n" + browserHistory[i]);
							//}
						}
						break;
				default: System.out.println("Wrong Choice!!");

			}
			System.out.print("\nDo you want to continue(y/n): ");
			ch = scanner.next().charAt(0);
			
		}while(ch == 'y');
		System.out.println("Adios.......");
		scanner.close();
		
	}

}
