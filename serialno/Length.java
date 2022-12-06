package serialno;

import java.io.File;
import java.util.Scanner;

public class Length {
	public int len() {
    	int a = 1;
    	try {
    		File f2 = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\data.txt");
    		Scanner sc4 = new Scanner(f2);
    		
    		while(sc4.hasNextLine()) {
    			sc4.nextLine();
    			a++;
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return a;    	
    }
}
