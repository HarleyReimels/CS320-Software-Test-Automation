package cs320;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {
	
	// Create Hashmap
	Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();
	
	// add contact method
	public void addContact(String uniqueID, String firstName, String lastName, String phoneNumber, String address) {
		// Create a new contact
        Contact contact = new Contact(uniqueID, firstName, lastName, phoneNumber, address);
        // See if the contact already exists by searching for the unique ID
        checkIfContactAlreadyExists(contact);
        // Add contact to contact list
        contactList.put(contact.getUniqueID(), contact);
    }
	
	public void shouldRemoveContact(String contactID) {	
		
		// Delete contact with matching first and last name
		if (contactList.containsKey(contactID)){
			contactList.remove(contactID);
		} else {
			throw new IllegalArgumentException("Contact Does not Exist");
		};
	}
	
	public void shouldUpdateContact(String key, String newFirstName, String newLastName, String newPhoneNumber, String newAddress) {	
		
		if (contactList.containsKey(key)) {
		// If contact exists update contact with name Harley
						
				// Only update and print changes to any item that has changed else skip
				if ((contactList.get(key).getFirstName() != newFirstName)) {
				contactList.get(key).setFirstName(newFirstName);
				}
				
				if ((contactList.get(key).getLastName() != newLastName)) {
				contactList.get(key).setLastName(newLastName);
				}
				
				if ((contactList.get(key).getPhoneNumber() != newPhoneNumber)) {
				contactList.get(key).setPhoneNumber(newPhoneNumber);
				}
				
				if ((contactList.get(key).getAddress() != newAddress)) {
				contactList.get(key).setAddress(newAddress);
				}
			}
		}
	
	
	
	
	
	private void checkIfContactAlreadyExists(Contact contact) {
		if (contactList.containsKey(contact.getUniqueID())) {
			throw new RuntimeException("Contact Already Exists");
		};
	}
	
	
	public Collection<Contact> getAllContacts(){
		return contactList.values();
	}
	
	
}
