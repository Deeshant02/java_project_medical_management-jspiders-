package password;

import java.io.File;
import java.util.Scanner;

public class Password {
	public String pass() throws Exception {
		File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\Password\\Password.txt");
        Scanner s = new Scanner(f);
        String pswd = s.next();
        s.close();
        return pswd;
	}
}
