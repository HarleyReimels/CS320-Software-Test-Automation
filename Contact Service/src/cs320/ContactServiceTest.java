package cs320;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactServiceTest {
	
	ContactService contactManager;
	
	@BeforeEach
	public void beforeTest() {
		contactManager = new ContactService();

	}
	
	
	// ********************************************************************************************
	// ************************* REQUIREMENTS FOR ADDING A NEW CONTACT ****************************
	// ********************************************************************************************
	
	// The contact service shall be able to add contacts with a unique ID.

	@Test
	@DisplayName("Add Contact")	
	public void shouldCreateContact() {	
		// Add one Contact to contactlist
		contactManager.addContact("CS-320","John", "Smith", "0123456789", "123 Home Lane");
		// Test for one
		Assertions.assertTrue(contactManager.contactList.containsKey("CS-320"));

	}

	// ********************************************************************************************
	// ************************* REQUIREMENTS FOR Removing A CONTACT ******************************
	// ********************************************************************************************
	
	// The contact service shall be able to delete contacts with a unique ID.

	@Test
	@DisplayName("Delete Contact")	
	public void shouldRemoveContact() {	
		// Add two contacts to contact list
		contactManager.addContact("CS-320","John", "Smith", "0123456789", "123 Home Lane");
		// Remove contact using unqiue id
		contactManager.shouldRemoveContact("CS-320");
		// Testing for 1 contact after deleting
		Assertions.assertFalse(contactManager.contactList.containsKey("CS-320"));
		}
		
	// ********************************************************************************************
	// ************************* REQUIREMENTS FOR UPDATING A CONTACT ******************************
	// ********************************************************************************************
	
	// The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
	// firstName
	// lastName
	// Number
	// Address

	@Test
	@DisplayName("Update Contact First Name")	
	public void testUpdateContactFirstName() {	
		contactManager.addContact("CS-320","John", "Smith", "0123456789", "123 Home Lane");
		contactManager.shouldUpdateContact("CS-320", "Harley", "Smith", "0123456789", "123 Home Lane");
		Assertions.assertTrue(contactManager.contactList.get("CS-320").getFirstName().equals("Harley"));
		}
		
	@Test
	@DisplayName("Update Contact Last Name")	
	public void testUpdateContactLastName() {	
		contactManager.addContact("CS-320","John", "Smith", "0123456789", "123 Home Lane");
		contactManager.shouldUpdateContact("CS-320", "John", "Reimels", "0123456789", "123 Home Lane");
		Assertions.assertTrue(contactManager.contactList.get("CS-320").getLastName().equals("Reimels"));
		}
		
	@Test
	@DisplayName("Update Contact Phone Number")	
	public void testUpdateContactPhoneNumber() {	
		contactManager.addContact("CS-320","John", "Smith", "0123456789", "123 Home Lane");
		contactManager.shouldUpdateContact("CS-320", "John", "Smith", "9876543210", "123 Home Lane");
		Assertions.assertTrue(contactManager.contactList.get("CS-320").getPhoneNumber().equals("9876543210"));
		
		}
		
	@Test
	@DisplayName("Update Contact Address")	
	public void testUpdateContactAddress() {	
		contactManager.addContact("CS-320","John", "Smith", "0123456789", "123 Home Lane");
		contactManager.shouldUpdateContact("CS-320", "John", "Smith", "0123456789", "Plymouth, MA");
		Assertions.assertTrue(contactManager.contactList.get("CS-320").getAddress().equals("Plymouth, MA"));
		}
		
}
	
	