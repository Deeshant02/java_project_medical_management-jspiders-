// multiple inheritance : App(super-class) --> ChangePass(sub-class) <-- I1(Super-class)
package password;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import Main.Main;

interface I1{
    void changePass(String pass);
}

public class ChangePassword extends Main implements I1 {
    public void changePass(String pass){
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter Old Password : ");
        String oldpas = sc2.next();
        if(oldpas.compareTo(pass)==0) {
        	System.out.print("\nEnter new Password : ");
        	String ps = sc2.next();
        	System.out.print("Confirm Password : ");
        	String cfps = sc2.next();
        	if(ps.compareTo(cfps)==0){
        		pass = ps;
        		System.out.print("Password changed sucessfully !!!\n\n\n");
        	}
        	else{
        		System.out.print("Password not matched !!!");
        	}
        	try{
        		File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\Password\\Password.txt");
        		f.createNewFile();
        		FileWriter fw = new FileWriter(f);
        		fw.write(pass);
        		fw.close();
        	}
        	catch(IOException e){
        		System.out.println("Error occur");
        	}
        }
        else {
        	System.out.print("\nEntered password is wrong !!!\n");
        }
        
    }
}