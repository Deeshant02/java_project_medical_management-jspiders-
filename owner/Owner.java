package owner;

import java.util.Scanner;
import Amount.Amount;

interface Own{ // Abstraction
	public void ownerSection(); // Method overriding(3. Polymorphism)
}

public class Owner extends Amount implements Own {
	public void ownerSection() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("\n\n\n+++++++++++++++++++++++++++++++++++++++++++++++\n\tStore Owner Section\n+++++++++++++++++++++++++++++++++++++++++++++++\n\n");
			System.out.println("\t1. Add New Medicine");
			System.out.println("\t2. Edit Medicine information");
			System.out.println("\t3. Remove Medicine From Shop");
			System.out.println("\t4. See Amount");
			System.out.println("\t5. Go Back To Main Menu");
			System.out.println("\t6. Exit");
			System.out.print("\n\tEnter Your Choice(1-4) ?        :     ");
			int choice3 = sc.nextInt();
		
			if(choice3 == 1) {
				AddNewMedicine c = new AddNewMedicine();
				System.out.println("\n\n\n");
				c.addMedicine();
			}
			else if(choice3 == 2) {
				System.out.print("\n\n\n\n===========================================\n\tEdit Medicine Information\n===========================================\n");
				System.out.print("\n\tEnter serial no. : ");
				int sr = sc.nextInt();
				EditMedicineInfo e = new EditMedicineInfo();
				e.editMedcine(sr);
			}
			else if(choice3 == 3) {
				System.out.print("\n\n===========================================\n\tRemove Medicine From Shop\n===========================================\n");
				System.out.print("\tEnter serial no. : ");
				int srr = sc.nextInt();
				srr-=1;
				RemoveMedicine g = new RemoveMedicine();
				g.removeMed(srr);
			}
			else if(choice3==4) {
				System.out.println("\n\n\n\n");
				for(int a=0;a<50;a++) {
					System.out.print("-");
				}
				System.out.println("\n\t\tAmount : "+getSal());
				
				for(int a=0;a<50;a++) {
					System.out.print("-");
				}
				System.out.println();
				System.out.println("\n\nPress any key + Enter to exit ...");
				sc.next().charAt(0);
			}
			else if(choice3 == 5) {
				System.out.println("\n\n\n");
				break;
			}
			else if(choice3 == 6) {
				System.exit(0);
			}
			else {
				System.out.print("\n\nInvalid Input !!!\n\nPlease try again !!!");
			}
			
		}
		
	}
}
