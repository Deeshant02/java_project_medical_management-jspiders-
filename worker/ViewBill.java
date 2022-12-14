package worker;

import java.io.Console;
import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;

import datatypefordata.DataType;

public class ViewBill {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public void viewOldBills() {
		try {
			File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\bill.txt");
			Scanner sc = new Scanner(f);
			DataType arr[] = new DataType[1000];
			int sr[] = new int[1000];
			String first[] = new String[1000];
			String last[] = new String[1000];
			int i = 0;
			int j = 0;
			
			for(int d=0;d<150;d++) {
				System.out.print("=");
			}
			System.out.println("\nsr no.\tname\t\t\tMedicine name\t\t\tcompany name\t\t\tquantity\t\tprice\t\ttype");
			for(int d=0;d<150;d++) {
				System.out.print("=");
			}
			String nam = null;
			while(sc.hasNextLine() && sc.hasNext()) {
				sr[j] = sc.nextInt();
				System.out.print("\n"+sr[j]);
				first[j] = sc.next();
				last[j] = sc.next();
				nam = first[j]+" "+last[j];
				System.out.print("\t"+nam);
				
				int dm = 0;
				
				while(sc.hasNext() && sc.hasNextInt() != true) {
					arr[i] = new DataType();
					
					if(dm >= 1) {
						for(int m=0;m<(8+nam.length());m++) {
							System.out.print(" ");
						}
					}
					
//					System.out.println(sc.hasNextLine());
					
					for(int m=0;m<(24-nam.length());m++) {
						System.out.print(" ");
					}
				
					arr[i].name = sc.next();
					System.out.print(arr[i].name);
					for(int m=0;m<(32-arr[i].name.length());m++) {
						System.out.print(" ");
					}
					arr[i].cmp = sc.next();
					System.out.print(arr[i].cmp);
					for(int m=0;m<(32-arr[i].cmp.length());m++) {
						System.out.print(" ");
					}
					arr[i].qty = sc.nextInt();
					System.out.print(arr[i].qty);
					String str = ""+arr[i].qty;
					for(int m=0;m<(24-str.length());m++) {
						System.out.print(" ");
					}
					arr[i].ppq = sc.nextDouble();
					System.out.printf(df.format(arr[i].ppq));
					String str1 = ""+df.format(arr[i].ppq);
					for(int m=0;m<(16-str1.length());m++) {
						System.out.print(" ");
					}
					arr[i].type = sc.next().charAt(0);
					System.out.println(arr[i].type);
					i++;
					dm++;
				}
				j++;
			}
			Scanner sc5 = new Scanner(System.in);
			System.out.print("\npress Enter to exit : ");
			
			sc5.nextLine();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
