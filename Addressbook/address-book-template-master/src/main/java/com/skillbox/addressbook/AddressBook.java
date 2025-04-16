package main.java.com.skillbox.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
private List<Contact> contacts;
public AddressBook(){contacts=new ArrayList<Contact>();}
public void  addContact(Contact contact){
if(contacts.isEmpty()) {
    System.out.println("В книге контактов нет записей");
    contacts.add(contact);
} else {

    for (Contact c:contacts){
        if(c.getSurname().equals(contact.getSurname())&& c.getName().equals(contact.getName())){
            System.out.println("Такой контакт существует и будет перезаписан");
            contacts.set(contacts.indexOf(c), contact);
            return;
        }
        else contacts.add(contact);
}


    }


}
    // Здесь будут храниться контакты.
    // Вам надо придумать, каким образом эти контакты будут храниться
    // в адресной книге.
    // Здесь вам необходимо реализовать методы для добавления, удаления
    // и получения контактов.
    // Рекомендуем также переопределить метод toString(), чтобы он вернул
    // список контактов.
}
