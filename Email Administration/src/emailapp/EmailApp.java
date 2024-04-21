package emailapp;
import java.util.*;
public class EmailApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice, newmailcapa;
		boolean exit = false;
		String newpass, altemail;
		String fn, ln;
		System.out.print("What is you first name? ");
		fn = in.nextLine();
		System.out.print("\nWhat is you last name? ");
		ln = in.nextLine();
		Email em = new Email(fn, ln);
		System.out.println(em.showInfo());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		do {
			System.out.println("1. Change Password\n2Set Alternate Email\n3. Set Mailbox Capacity\n4. Exit\n");
			choice = in.nextInt();
			switch(choice) {
			case 1:{
				System.out.print("Input new Password: ");
				newpass = in.nextLine();
				em.changePassword(newpass);
				break;
			}
			case 2:{
				System.out.print("Input alternative email: ");
				altemail= in.nextLine();
				em.setAlternateEmail(altemail);
				break;
			}
			case 3:{
				System.out.print("Enter new mailbox capacity: ");
				newmailcapa = in.nextInt();
				em.setMailboxCapacity(newmailcapa);
				break;
			}
			case 4:{
				exit = true;
				break;
				}
			default:{
				throw new IllegalArgumentException("Invalid Input: "+choice);
			}
			}
		
		}while(!exit);
	}

}
