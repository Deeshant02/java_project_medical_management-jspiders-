package owner;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import datatypefordata.DataType;
import serialno.Length;

public class RemoveMedicine {
	public void removeMed(int srr) {
		try {
			Length l = new Length();
			int h = l.len();
		
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
			
			System.out.println("Medicine Name    : "+arr[srr].name);
			System.out.println("Medicine Company : "+arr[srr].cmp);
			System.out.println("Quantity 	 : "+arr[srr].qty);
			System.out.println("Price/Quantity   : "+arr[srr].ppq);
			System.out.println("Medicine Type    : "+arr[srr].type);
			
			Scanner sc6 = new Scanner(System.in);
			
			while(true) {
				System.out.print("Are you sure you want to delete medicine from store(y/n) : ");
				char ayw = sc6.next().charAt(0);
				if(ayw=='y' || ayw=='Y') {
					System.out.print("removing record ");
					for(int z=0;z<4;z++) {
						Thread.sleep(500);
						System.out.print(".");
					}
					break;
				}
				else if(ayw == 'n' || ayw=='N') {
					return;
				}
				else {
					System.out.println("Invalid Input !!!");
				}
			}
			
			for(int j = srr;j<(h-2);j++) {
				arr[j].name = arr[j+1].name;
				arr[j].cmp = arr[j+1].cmp;
				arr[j].qty = arr[j+1].qty;
				arr[j].ppq = arr[j+1].ppq;
				arr[j].type = arr[j+1].type;
			}
			
			String fwt = null;
			
			f.createNewFile();
			
			FileWriter fw = new FileWriter(f);
			
			for(int j=0;j<(h-2);j++) {
				
				fwt = arr[j].srn + " " + arr[j].name + " " + arr[j].cmp + " " + arr[j].qty + " " + arr[j].ppq + " " + arr[j].type + "\n";
//				System.out.println(arr[j].name);
				
				fw.write(fwt);
			}
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
