package main.java.com.skillbox.addressbook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    Contact contact;
    private List<Contact> contacts;
    Scanner scanner = new Scanner(System.in);

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
            System.out.println(("\u001B К удалению!!! \u001B[0m").toUpperCase() + System.lineSeparator() + contactToRemove);
            System.out.println("Удаляем контакт?y/n");
            String answer = scanner.nextLine();
            if (answer.equals("y")) {
                contacts.remove(contactToRemove);
                if (contactToRemove == null) {
                    System.out.println("Контакт удалён");
                }
            }
        }
    }


    public Contact readContactFromConsole(Contact contact) {

        System.out.println("Введите Имя");
        contact.setName(scanner.nextLine());
        System.out.println("Введите Фамилию");
        contact.setSurname(scanner.nextLine());
        System.out.println("Введите Отчество");
        contact.setPatronymic(scanner.nextLine());
        if (contact.getPatronymic().isEmpty()) {
            contact.setPatronymic("Нет отчества");
        }
        System.out.println("Введите Дату рождения формата yyyy-MM-dd");
        try {
            contact.setBirthday(LocalDate.parse(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("\u001B[31mДата рождения в формате yyyy-MM-dd\u001B[0m");
            contact.setBirthday(LocalDate.parse(scanner.nextLine()));
        }
        System.out.println("Введите Должность");
        contact.setPost(scanner.nextLine());
        System.out.println("Введите номер телефона");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.println("Введите адрес электронной почты");
        contact.setEmail(scanner.nextLine());

        return contact;


    }


}
