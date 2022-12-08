package Main;

import java.util.Scanner;
import ListMed.ListMedicines;
import password.*;
import owner.Owner;
import worker.Workers;
import Amount.ReadWriteAmount;

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
		ReadWriteAmount rwa = new ReadWriteAmount();
		rwa.readAmount();
		while(true) {
			System.out.println("\n\n");
			for(int a=0;a<76;a++) {
				System.out.print("*");
			}
			System.out.print("\n\t\t1. Owner Section\n\t\t2. Worker Section\n\t\t3. List Of Medicines\n\t\t4. Change Password\n\t\t5. Exit\n\n\n\t\tEnter Your Choice ?(1-5)        :    ");
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
				ListMedicines lm = new ListMedicines();
				lm.listMed();
			}
			else if(choice==4) {
				try {
					Password p1 = new Password();
					String pswd = p1.pass();
					ChangePassword cp = new ChangePassword();
					System.out.println("\n\n\n\n");
					cp.changePass(pswd);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(choice==5) {
				System.exit(0);
			}
			else {
				System.out.print("\n\nInvalid Input !!!\n\nPlease try again !!!");
			}
		}
	}
}