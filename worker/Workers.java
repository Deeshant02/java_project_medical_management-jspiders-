package worker;

import java.util.Scanner;

public class Workers {
	public void workerSection() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("\n\n\n+++++++++++++++++++++++++++++++++++++++++++++++\n\tStore Work Section\n+++++++++++++++++++++++++++++++++++++++++++++++\n\n");
			System.out.println("\t1. Sell Medicine\n\t2. View previous Bills\n\t3. Back to Main Menu\n\t4. Exit\n");
			System.out.print("Enter your choice(1-4) ?     :      ");
			int ch4 = sc.nextInt();
		
			if(ch4 == 1) {
				SellMedicine sm = new SellMedicine();
				sm.sellMed();
			}
			else if(ch4 == 2) {
				ViewBill vb = new ViewBill();
				vb.viewOldBills();
			}
			else if(ch4 == 3) {
				break;
			}
			else if(ch4 == 4) {
				System.exit(0);
			}
		}
	}
}
