package Amount;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadWriteAmount {
	public void readAmount() {
		float a=0;
		Amount am = new Amount();
		try {
			File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\amount\\amount.txt");
			Scanner sc = new Scanner(f);
			a = sc.nextFloat();
			am.setSal(a);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void writeAmount(float a) {
		try {
			File f1 = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\amount\\amount.txt");
			f1.createNewFile();
			FileWriter fw = new FileWriter(f1);
			fw.write(""+a);
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
