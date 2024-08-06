package org.example.mobile;

import java.util.List;

public class MobilePhone {

    private String myNumber;
    private List<Contact> myContacts;

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;

    }

    public boolean addNewContact(Contact contact) {
        if(contact == null || contact.getName() == null || contact.getPhoneNumber() == null) return false;
        if(findContact(contact.getName()) != -1) {
            return false;
        } else {
            return myContacts.add(contact);
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if(findContact(oldContact) > -1) {
            int index = findContact(oldContact);
            myContacts.set(index, newContact);
            return true;
        } else return false;
    }

    public boolean removeContact(Contact contact) {
        if(findContact(contact) != -1) {
            myContacts.remove(findContact(contact));
            return true;
        } else return false;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if(myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index < 0) return null;
        return myContacts.get(index);
    }

    public void printContact() {
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }

}
