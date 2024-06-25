package cs320;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {
	Contact contact;
	
// ------------------------ Tests For Constructor ----------------- //	
	@Test
	
	@DisplayName("Start Test")
	public void testCreateContact() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		assertAll("Testing all elements of creating new user",
		() -> Assertions.assertTrue(contact.getUniqueID().equals("CS-320")),
		() -> Assertions.assertTrue(contact.getFirstName().equals("John")),
		() -> Assertions.assertTrue(contact.getLastName().equals("Smith")),
		() -> Assertions.assertTrue(contact.getPhoneNumber().equals("0123456789")),
		() -> Assertions.assertTrue(contact.getAddress().equals("123 Home Lane"))
	);
	}
	
	@Test
	@DisplayName("Unique ID Null")
	public void testUniqueIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact(null, "John", "Smith", "0123456789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Unique ID to Long")
	public void testUniqueIDToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320cscscscscscscscscscs", "John", "Smith", "0123456789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("First Name Null")
	public void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", null, "Smith", "0123456789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("First Name to Long")
	public void testFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "JohnJacobJingleHeimer", "Smith", "0123456789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Last Name Null")
	public void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", null, "0123456789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Last Name to Long")
	public void testLastNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "JacobJingleHeimerSmith", "0123456789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Phone Number Null")
	public void testPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "Smith", null, "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Phone number > 10")
	public void testPhoneNumberLengthToMany() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "JacobJingleHeimerSmith", "11111110123456789", "123 Home Lane");
		});
	}
	@Test
	@DisplayName("Phone number < 10")
	public void testPhoneNumberLengthToFew() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "JacobJingleHeimerSmith", "6789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Phone Number non-digit")
	public void testPhoneNumberToNonDigit() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "Smith", "0R2F45G789", "123 Home Lane");
		});
	}
	
	@Test
	@DisplayName("Address null")
	public void testAddressToNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "Smith", "0123456789", null);
		});
	}
	
	@Test
	@DisplayName("Address to long")
	public void testAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("CS-320", "John", "Smith", "0123456789", "777 North Pole Candy Cane Lane Workshop 1");
		});
	}
	
	// ------------------------------- Tests For Setters -----------------------------------------//
	
	@Test
	@DisplayName("Change First Name Null")
	public void testChangeFirstNameNull() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName(null);
		});
	}
	
	@Test
	@DisplayName("Change First Name to Long")
	public void testChangeFirstNameToLong() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName("JohnJacobJingleHeimer");
		});
	}
	
	@Test
	@DisplayName("Change Last Name Null")
	public void testChangeLastNameNull() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName(null);
		});
	}
	
	@Test
	@DisplayName("Change Last Name to Long")
	public void testChangeLastNameToLong() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName("JacobJingleHeimerSmith");
		});
	}
	@Test
	@DisplayName("Change Phone Number Null")
	public void testChangePhoneNumberNull() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	@DisplayName("Change Phone Number to Long")
	public void testChangePhoneNumberToLong() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhoneNumber("11111111222222222233333333333444444444444");
		});
	}

	
	@Test
	@DisplayName("Change Phone Number to Short")
	public void testChangePhoneNumberToShort() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhoneNumber("1111");
		});
	}
	
	@Test
	@DisplayName("Change Phone Number to non-digit")
	public void testChangePhoneNumberToNonDigit() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhoneNumber("0Q123C5678");
		});
	}
	
	@Test
	@DisplayName("Change Address to Null")
	public void testChangeAddressNull() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress(null);
		});
	}
	
	@Test
	@DisplayName("Change Last Name to Long")
	public void testChangeAddressToLong() {
		contact = new Contact("CS-320", "John", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress("777 North Pole Candy Cane Lane Workshop 1");
		});
	}
	
	
}