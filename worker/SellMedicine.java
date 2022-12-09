package worker;

import java.io.File;
import java.util.Scanner;
import datatypefordata.DataType;
import serialno.BillSrNo;
import serialno.Length;
import java.io.FileWriter;
import Amount.Amount;
import java.text.DecimalFormat;

interface Sm{ // Abstraction
	public void sellMed(); // method overriding(3. Polymorphism)
}

public class SellMedicine extends Amount implements Sm {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public void sellMed() {
		try {
			Scanner sc5 = new Scanner(System.in);
			float amt=getSal();
			
		
			File f = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\data.txt");
			Scanner sc = new Scanner(f);
			DataType arr[] = new DataType[1000];
			
			int sr[] = new int[1000];
			String first[] = new String[1000];
			String last[] = new String[1000];
			
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
			
			String fw = "";
			
			boolean dyw = true;
			double price = 0;
			
			System.out.print("Enter customer first name : ");
			String fname = sc5.next();
			
			System.out.print("Enter customer last name : ");
			String lname = sc5.next();
			
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
					
					System.out.print("Enter quantity of medicine customer want : ");
					int qt = sc5.nextInt();
					fw += arr[ms].name + " " + arr[ms].cmp + " " + qt + " " + df.format((qt*arr[ms].ppq)) + " " + arr[ms].type + " ";
					arr[ms].qty -= qt;
					amt += (qt*arr[ms].ppq);
					price += (qt*arr[ms].ppq);
					
					System.out.println("Total Amount : "+df.format(price));
					
					f.createNewFile();
					FileWriter fwt = new FileWriter("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\data.txt");
					
					for(int d=0;d<(e-1);d++) {
						String wt = arr[d].srn + " " + arr[d].name + " " + arr[d].cmp + " " + arr[d].qty + " " + arr[d].ppq + " " + arr[d].type + "\n";
						fwt.write(wt);
					}
					
					fwt.close();
					price += qt*arr[ms].ppq;
					
					System.out.println("Customer want another medicine(y/n) : ");
					char dywm = sc5.next().charAt(0);
					
					if(dywm == 'y' || dywm == 'Y') {
						dyw = true;
					}
					else if(dywm == 'n' || dywm == 'N') {
						dyw = false;
						
						BillSrNo bs = new BillSrNo();
						
						int srno = bs.len();
						
						fw = srno + " " + fname + " " + lname + " " + fw + "\n";
						
						File f1 = new File("E:\\Eclipse\\Medical_Management_System_1.0\\src\\Data\\medicines_data\\bill.txt");
						FileWriter fwb = new FileWriter(f1, true);
						fwb.write(fw);
						fwb.close();
						
						Scanner scr = new Scanner(fw);
						String nam = null;
						i=0;
						int j=0;
						System.out.println("\n\n");
						for(int d=0;d<150;d++) {
							System.out.print("=");
						}
						System.out.println("\n\t\t\t\t\t\t\t\tBill");
						for(int d=0;d<150;d++) {
							System.out.print("=");
						}
						System.out.println("\nsr no.\tname\t\t\tMedicine name\t\t\tcompany name\t\t\tquantity\t\tprice\t\ttype");
						for(int d=0;d<150;d++) {
							System.out.print("=");
						}
						
						while(scr.hasNextLine() && scr.hasNext()) {
							sr[j] = scr.nextInt();
							int srj = 1;
							System.out.print("\n"+srj);
							first[j] = scr.next();
							last[j] = scr.next();
							nam = first[j]+" "+last[j];
							System.out.print("\t"+nam);
							int dm = 0;
							while(scr.hasNext()) {
								arr[i] = new DataType();
								
								if(dm >= 1) {
									for(int m=0;m<(8+nam.length());m++) {
										System.out.print(" ");
									}
								}
								
								for(int m=0;m<(24-nam.length());m++) {
//									System.out.print("-");
									System.out.print(" ");
								}
							
								arr[i].name = scr.next();
								System.out.print(arr[i].name);
								for(int m=0;m<(32-arr[i].name.length());m++) {
									System.out.print(" ");
								}
								arr[i].cmp = scr.next();
								System.out.print(arr[i].cmp);
								for(int m=0;m<(32-arr[i].cmp.length());m++) {
									System.out.print(" ");
								}
								arr[i].qty = scr.nextInt();
								System.out.print(arr[i].qty);
								String str = ""+arr[i].qty;
								for(int m=0;m<(24-str.length());m++) {
									System.out.print(" ");
								}
								arr[i].ppq = scr.nextDouble();
								System.out.print(arr[i].ppq);
								String str1 = ""+arr[i].ppq;
								for(int m=0;m<(16-str1.length());m++) {
									System.out.print(" ");
								}
								arr[i].type = scr.next().charAt(0);
								System.out.println(arr[i].type);
								i++;
								dm++;
							}
							j++;
						}
						
						System.out.print("Press any key + Enter to exit : ");
						sc5.next().charAt(0);
					}
					
					
				}
			}
			setSal(amt);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
