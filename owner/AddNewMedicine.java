package owner;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import serialno.Length;

public class AddNewMedicine {
	public void addMedicine() {
		Scanner sc = new Scanner(System.in);
		
		Length d = new Length();
		
		int srn = d.len();
		
		System.out.print("Enter medicine name : ");
		String name = sc.next();
		
		System.out.print("Enter medicine Company name : ");
		String cmp = sc.next();
		
		System.out.print("Enter Quantity : ");
		int qty = sc.nextInt();
		
		System.out.print("Enter price/quantity : ");
		double ppq = sc.nextDouble();
		
		System.out.print("Enter medicine type(liquid : l or tablet : t) : ");
		char type = sc.next().charAt(0);
		
		writeInFile(srn, name, cmp, qty, ppq, type);
	}
	
	public void writeInFile(int srn, String name, String cmp, int qty, double ppq, char type) {
		String fwt = srn + " " + name + " " + cmp + " " + qty + " " + ppq + " " + type + "\n";
        
	    System.out.println(fwt);

	    try{
	        File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\data.txt");
//	        f.createNewFile();
	        FileWriter fw = new FileWriter(f,true);
	        fw.write(fwt);
	        fw.close();
	    }
	    catch(Exception e){
	        System.out.println("Error occur");
	    }
	}
}
