import java.util.*;

class Browser{
	private  String[] history = new String[1];
	private int historyIndex = 0;
	
	public Browser() {	//empty constructor
	}
	
	public Browser(String[] urls) {	//constructor
			for(int i=0; i<urls.length; ++i) {
				try {
				this.history[this.historyIndex] = urls[i];
				}
				catch(Exception e) {
					this.growSize();
					this.history[this.historyIndex] = urls[i];
				}
				this.historyIndex ++;
			
		}
		
	}
	
	public void addBrowser(String url) { //to add new url to history
		try {
			this.history[this.historyIndex] = url;
			this.historyIndex ++;
		}
		catch(Exception e) {
			this.growSize();
			this.history[this.historyIndex] = url;
			this.historyIndex ++;
		}
	}
	
	public String[] accessHistory() {	//to display all the browser history
		return history;
	}
	
	private void growSize() {	//to increase the array size upon exception
		String[] temp = null;
		temp = new String[this.historyIndex * 2];
		for(int i=0; i< this.historyIndex; ++i) {
			temp[i] = this.history[i];
		}
		this.history = temp;
		
	}
	public int accessHistorySize() {
		return this.history.length;
	}
}


public class BrowserHandling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputUrl = new String();
		char ch = 'y';
		int choice;
		String browserChoice = new String();
		Browser chrome = new Browser();
		Browser firefox = new Browser();
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
						if (browserChoice.equals("firefox")) {
							firefox.addBrowser(inputUrl);
						}
						else {
							chrome.addBrowser(inputUrl);
						}
						break;
				case 2: System.out.print("\nEnter the browser: ");
						browserChoice = scanner.next();
						if (browserChoice.equals("firefox")) {
							String[] browserHistory = new String[firefox.accessHistorySize()];
							browserHistory = Arrays.copyOf(firefox.accessHistory(), 10);
							for(int i=0;i<firefox.accessHistorySize();++i) {
								System.out.println("\n" + browserHistory[i]);
							}
						
						}
						else {
							String[] browserHistory = new String[chrome.accessHistorySize()];
							browserHistory = Arrays.copyOf(chrome.accessHistory(), 10);
							for(int i=0;i<chrome.accessHistorySize();++i) {
								System.out.println("\n" + browserHistory[i]);
							}
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
