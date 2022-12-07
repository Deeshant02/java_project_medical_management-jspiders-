package ListMed;

import java.util.Scanner;
import datatypefordata.DataType;
import serialno.Length;

import java.io.File;
import java.io.FileNotFoundException;

public class ListMedicines {
	public void listMed() throws FileNotFoundException {
		try {
			File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\data.txt");
			Scanner sc = new Scanner(f);
			DataType arr[] = new DataType[1000];
			int i = 0;
			while(sc.hasNextLine() && sc.hasNext()) {
				arr[i] = new DataType();
				
				arr[i].srn = sc.nextInt();
				arr[i].name = sc.next();
				arr[i].cmp = sc.next();
				arr[i].qty = sc.nextInt();
				arr[i].ppq = sc.nextDouble();
				arr[i].type = sc.next().charAt(0);
				
				i++;
			}
			Length k = new Length();
			int e = k.len();
			
			for(int l=0;l<150;l++) {
				System.out.print("=");
			}
			System.out.println();
			
			System.out.print("Sr no.\t\t");
			System.out.print("Medicine name\t\t\t");
			System.out.print("Company\t\t\t");
			System.out.print("Quantity\t");
			System.out.print("Price/Qty\t\t");
			System.out.print("Type");
			
			System.out.println();			
			for(int l=0;l<150;l++) {
				System.out.print("=");
			}
			System.out.println();
			for(int j=0;j<(e-1);j++) {
				System.out.print("\n"+arr[j].srn);
				for(int a=0;a<14;a++) {
					System.out.print(" ");
				}
				System.out.print(arr[j].name);
				for(int a=0;a<(33-arr[j].name.length());a++) {
					System.out.print(" ");
				}
				System.out.print(arr[j].cmp);
				for(int a=0;a<(24-arr[j].cmp.length());a++) {
					System.out.print(" ");
				}
				System.out.print(arr[j].qty);
				
				String q = ""+arr[j].qty;
				
				for(int a=0;a<(16-q.length());a++) {
					System.out.print(" ");
				}
				System.out.print(arr[j].ppq);
				String prpq = ""+arr[j].ppq;
				for(int a=0;a<(24-prpq.length());a++) {
					System.out.print(" ");
				}
				System.out.print(arr[j].type);
			}
			Scanner sc7 = new Scanner(System.in);
			System.out.print("\n\npress any key + Enter to go back ... ");
			sc7.next().charAt(0);
			System.out.println("\n\n\n\n\n");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
