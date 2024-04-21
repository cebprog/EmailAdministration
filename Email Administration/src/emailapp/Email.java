package emailapp;
import java.util.*;
public class Email {
	private String FirstName;
	private String LastName;
	private String Password;
	private String email;
	private int defaultPassswordLength = 10;
	private String Department;
	private int MailboxCapacity=500;
	private String AlternateEmail;
	private String companySuffix = "aeycompany.com";
	
	//constructor to receive first name and last name
	public Email(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		//call method asking for department -> return department
		this.Department = setDepartment();

		
		//call a method that return random password
		this.Password = randomPassword(this.defaultPassswordLength);
		System.out.println("Password: "+this.Password);
		
		//combine elements to generate email
		email = FirstName.toLowerCase()+"."+LastName.toLowerCase()+"@"+Department.toLowerCase()+"."+companySuffix;
	}
	//ask for the department
	private String setDepartment() {
		System.out.print("New Worker: "+ FirstName+" "+LastName+"\nDEPARTMENT CODES\n1. Sales\n2. Development\n3. Accounting\n0. none\nEnter Department Code:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) 
			return "Sales";
		else if(depChoice == 2) 
			return "Development";
		else if(depChoice == 3) 
			return "Accounting";
		else 
			return "";
	}
	//generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@$%";
		char[] password = new char[length];
		for(int i =0; i<length; i++) {
			int rand =(int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	// set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.MailboxCapacity = capacity;
	}
	// set alternate email
	public void setAlternateEmail(String altEmail) {
		this.AlternateEmail = altEmail;
	}
	//change the password
	public void changePassword(String password) {
		this.Password = password;
	}
	
	
	public int getMailboxCapacity() {
		return this.MailboxCapacity;
	}
	public String getAltEmail () {
		return this.AlternateEmail;
	}
	public String getPassword() {
		return this.Password;
	}
	public String showInfo() {
		return "Display Name: " + FirstName+" "+LastName+
				"\nCompany Email: "+email+ "\nMailbox Capacity: "+
				MailboxCapacity+"mb";
	}
}
