package Amount;

// Amount class is a super class of SellMedicine and Qwner class ==> hierarchical inheritance(2. Inheritance)

public class Amount {
	private static float amount = 0;//private ==> data hidding
	
	ReadWriteAmount rwa = new ReadWriteAmount();
	
	// Getter method(1. Encapsulation)
	public float getSal() {
		return amount;
	}
	
	// Setter method(1. Encapsulation)
	public void setSal(float amt) {
		amount = amt;
		rwa.writeAmount(amt);
	}
}
