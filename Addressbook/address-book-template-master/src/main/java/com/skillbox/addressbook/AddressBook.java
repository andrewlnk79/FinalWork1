package main.java.com.skillbox.addressbook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    Contact contact;
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact() {
        Contact contact = new Contact();
        contact = readContactFromConsole(contact);
        if (contacts.isEmpty()) {
            System.out.println("В книге контактов нет записей");
            contacts.add(contact);
        } else {

            for (Contact c : contacts) {
                if (c.getSurname().equals(contact.getSurname()) && c.getName().equals(contact.getName())) {
                    System.out.println("Такой контакт существует и будет перезаписан!");
                    contacts.set(contacts.indexOf(c), contact);
                    return;
                } else contacts.add(contact);
            }


        }


    }

    public void getContact(Contact contact, String surname) {
        for (Contact с : contacts) {
            if (с.getSurname().equals(surname)) {
                System.out.println(с);
                break;
            }
        }

    }

    public void getAllContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }


    public void deleteContactBySurname(String surname) {
        Contact contactToRemove = null;
        for (Contact с : contacts) {
            if (с.getSurname().equals(surname)) {
                contactToRemove = с;
                break;
            }
        }
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);

        }
    }


    public Contact readContactFromConsole(Contact contact) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Имя");
        contact.setName(scanner.next());
        System.out.println("Введите Фамилию");
        contact.setSurname(scanner.next());
        System.out.println("Введите Отчество");
        System.out.println("Введите Дату рождения");
        contact.setBirthday(LocalDate.parse(scanner.next()));
        contact.setPatronymic(scanner.next());
        System.out.println("Введите Должность");
        contact.setPost(scanner.next());
        System.out.println("Введите номер телефона");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Введите адрес электронной почты");
        contact.setEmail(scanner.next());
        scanner.close();
        return contact;


    }

    // Здесь будут храниться контакты.
    // Вам надо придумать, каким образом эти контакты будут храниться
    // в адресной книге.
    // Здесь вам необходимо реализовать методы для добавления, удаления
    // и получения контактов.
    // Рекомендуем также переопределить метод toString(), чтобы он вернул
    // список контактов.
}
