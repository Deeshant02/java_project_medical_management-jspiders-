package worker;

import java.io.File;
import java.util.Scanner;
import datatypefordata.DataType;
import serialno.Length;
import java.io.FileWriter;

public class SellMedicine {
	public void sellMed() {
		try {
			Scanner sc5 = new Scanner(System.in);
		
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
			
			String fw = null;
			
			boolean dyw = true;
			while(dyw) {
				System.out.print("Enter medicine name : ");
				String med = sc5.next();
				med = med.toLowerCase();
				int ms = 1001;
		
				for(int l = 0;l<(e-1);l++) {
					if((arr[l].name.toLowerCase()).compareTo(med) == 0) {
						ms = l;
						break;
					}
				}
			
				if(ms == 1001) {
					System.out.println("Medicine is not available in store !!!");
				}
				else {
					System.out.println("Enter quantity of medicine customer want : ");
					int qt = sc5.nextInt();
					fw = arr[ms].name + " " + arr[ms].cmp + " " + qt + " " + (qt*arr[ms].ppq) + " " + arr[ms].type + "\n";
					arr[ms].qty -= qt;
					
					f.createNewFile();
					FileWriter fwt = new FileWriter("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\data.txt");
					
					for(int d=0;d<(e-1);d++) {
						String wt = arr[d].srn + " " + arr[d].name + " " + arr[d].cmp + " " + arr[d].qty + " " + arr[d].ppq + " " + arr[d].type + "\n";
						fwt.write(wt);
					}
					
					System.out.println("Customer want another medicine(y/n) : ");
					char dywm = sc.next().charAt(0);
					
					if(dywm == 'y' || dywm == 'Y') {
						dyw = true;
					}
					else if(dywm == 'n' || dywm == 'N') {
						dyw = false;
						fw += "\n";
					}
					
					fwt.close();
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
