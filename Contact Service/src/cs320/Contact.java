package cs320;

public class Contact {
	
	// Establish variables
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String uniqueID;
	
	// Default Constructor assigning the variables to the contact
	public Contact(String uniqueID, String firstName, String lastName, String phoneNumber, String address) {

		// The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. 
		// The contact ID shall not be null and shall not be updatable.

		if (uniqueID == null || uniqueID.length() > 10){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.uniqueID = uniqueID;
		}
		
		
		// The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.

		if (firstName == null || firstName.length() > 10){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.firstName = firstName;
		}
		
		// The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.

		if (lastName == null || lastName.length() > 10){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.lastName = lastName;
		}

		
		// The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
		
		if (phoneNumber == null || !(phoneNumber.matches("\\d+") || (phoneNumber.length() != 10))) {
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.phoneNumber = phoneNumber;
		}
		

		// The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.

		if (address == null || (address.length() > 30)){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.address = address;
	}
}
	
// -------------------------------------Setters ------------------------------
	
	// Setters for each of the variables
	public void setFirstName(String newFirstName){
		if (newFirstName == null || newFirstName.length() > 10){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.firstName = newFirstName;
		}
	}
	
	public void setLastName(String newLastName){
		if (newLastName == null || newLastName.length() > 10){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.lastName = newLastName;
		}
	}
	
	// !(newPhoneNumber.matches("\\d+")
	public void setPhoneNumber(String newPhoneNumber){
		if (newPhoneNumber == null || (newPhoneNumber.length() != 10) || !(newPhoneNumber.matches("\\d+"))) {
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.phoneNumber = newPhoneNumber;
		}
	}
	
	public void setAddress(String newAddress) {
		if (newAddress == null || (newAddress.length() > 30)){
			throw new IllegalArgumentException("Invalid Input");
		} else {			
			this.address = newAddress;
		}
	}
		
// --------------------------------- GETTERS ----------------------------
	
	// Getters for each of the variables
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getUniqueID() {
		return this.uniqueID;
	}
	
	
	
}