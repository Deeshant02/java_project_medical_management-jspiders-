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
				System.out.println(arr[j].name);
				
				fw.write(fwt);
			}
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
