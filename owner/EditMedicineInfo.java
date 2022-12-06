package owner;

import java.io.File;
import java.util.Scanner;
import datatypefordata.DataType;
import java.io.FileWriter;
import serialno.Length;

public class EditMedicineInfo {
	public void editMedcine(int sr) {
		try {
			Scanner sc4 = new Scanner(System.in);
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
			
//			arr[0].name = "paracetamol";
			
			Length k = new Length();
			int e = k.len();
			
			String fwt = null;
			
			if(sr<e) {
				System.out.println("------------------xxxx Previous details xxxx------------------\n");
				System.out.println("\tSerial no.          : " + arr[sr-1].srn);
				System.out.println("\tName                : " + arr[sr-1].name);
				System.out.println("\tCompany name        : " + arr[sr-1].cmp);
				System.out.println("\tQuantity            : " + arr[sr-1].qty);
				System.out.println("\tPrice per Quantity  : " + arr[sr-1].ppq);
				System.out.println("\tMedicine Type       : " + arr[sr-1].type);
				
				System.out.println("\n\n\n---------------xxxx Enter new details xxxx---------------\n");
				System.out.print("\tName                : ");
				arr[sr-1].name = sc4.next();
				System.out.print("\tCompany name        : ");
				arr[sr-1].cmp = sc4.next();
				System.out.print("\tQuantity            : ");
				arr[sr-1].qty = sc4.nextInt();
				System.out.print("\tPrice per Quantity  : ");
				arr[sr-1].ppq = sc4.nextDouble();
				System.out.print("\tMedicine Type       : ");
				arr[sr-1].type = sc4.next().charAt(0);
				
				f.createNewFile();
				
				FileWriter fw = new FileWriter(f);
				
				for(int j=0;j<(e-1);j++) {
					
					fwt = arr[j].srn + " " + arr[j].name + " " + arr[j].cmp + " " + arr[j].qty + " " + arr[j].ppq + " " + arr[j].type + "\n";
//					System.out.println(arr[j].name);
					
					fw.write(fwt);
				}
				
				fw.close();
			}
			else {
				System.out.println("Serial number is out of range !");
			}
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
