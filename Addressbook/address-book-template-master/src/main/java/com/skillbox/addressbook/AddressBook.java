package main.java.com.skillbox.addressbook;

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
            System.out.println("В книге контактов нет записей Добавим новую");
            contacts.add(contact);
            if (contacts.contains(contact)) {
                System.out.println("Контакт добавлен");
            }
        } else {

            for (Contact c : contacts) {
                if (c.getSurname().equals(contact.getSurname()) && c.getName().equals(contact.getName())) {
                    System.out.println("Пользователь" + contact.getName() + " " + contact.getPatronymic() + " " + contact.getSurname() + "уже присутствует в списке\n" +
                            "контактов, он будет обновлён в соответствии с новыми данными.");
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
        if (contacts.isEmpty()) {
            System.out.println("В книге контактов нет записей");
        }
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
        contact.setName(scanner.nextLine());
        System.out.println("Введите Фамилию");
        contact.setSurname(scanner.nextLine());
        System.out.println("Введите Отчество");
        contact.setPatronymic(scanner.nextLine());
        System.out.println("Введите Дату рождения");
        contact.setBirthday(scanner.nextLine());
        System.out.println("Введите Должность");
        contact.setPost(scanner.nextLine());
        System.out.println("Введите номер телефона");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.println("Введите адрес электронной почты");
        contact.setEmail(scanner.nextLine());
        return contact;


    }


}
