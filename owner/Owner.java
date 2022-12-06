package owner;

import java.util.Scanner;

public class Owner {
	public void ownerSection() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("\n\n\n+++++++++++++++++++++++++++++++++++++++++++++++\n\tStore Owner Section\n+++++++++++++++++++++++++++++++++++++++++++++++\n\n");
			System.out.println("\t1. Add New Medicine");
			System.out.println("\t2. Edit Medicine information");
			System.out.println("\t3. Remove Medicine From Shop");
			System.out.println("\t4. Go Back To Main Menu");
			System.out.println("\t5. Exit");
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
			else if(choice3 == 4) {
				System.out.println("\n\n\n");
				break;
			}
			else if(choice3 == 5) {
				System.exit(0);
			}
			else {
				System.out.print("\n\nInvalid Input !!!\n\nPlease try again !!!");
			}
			
		}
		
	}
}
