package Main;

import java.util.Scanner;
import password.*;
import owner.Owner;
import worker.Workers;

public class Main {	
	static {
		Scanner sc1 = new Scanner(System.in);
		String pswd = "";
		try {
			Password p = new Password();
			pswd = p.pass();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		for(int i=2;i>=0;i--) {
			System.out.print("Enter password : ");
			String pas = sc1.next();
			
			if(pswd.compareTo(pas)!=0) {
				System.out.println("Wrong password !!!");
				if(i==0) {
					System.out.print("Try again later !!!");
					System.exit(0);
				}
				System.out.printf("You have %d attempts left!!!\n\n",i);
			}
			else {
				System.out.print("\n\n\n\n");
				break;
			}
			
		}
	}
	
	static {
		System.out.print("****************************************************************************\n\t\tWelcome To Good Life Pharma Medical\n****************************************************************************\n");
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("\n\n\t\t1. Owner Section\n\t\t2. Worker Section\n\t\t3. Change Password\n\t\t4. Exit\n\n\n\t\tEnter Your Choice ?(1-3)        :    ");
			int choice = sc.nextInt();
			if(choice==1) {
				Owner b = new Owner();
				b.ownerSection();
			}
			else if(choice==2) {
				Workers w = new Workers();
				w.workerSection();
			}
			else if(choice==3) {
				try {
					Password p1 = new Password();
					String pswd = p1.pass();
					ChangePassword cp = new ChangePassword();
					cp.changePass(pswd);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(choice==4) {
				System.exit(0);
			}
			else {
				System.out.print("\n\nInvalid Input !!!\n\nPlease try again !!!");
			}
		}
	}
}