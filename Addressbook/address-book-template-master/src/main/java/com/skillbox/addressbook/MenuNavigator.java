package main.java.com.skillbox.addressbook;

import java.util.Scanner;

public class MenuNavigator {
    AddressBook addressBook = new AddressBook();
    Contact contact;
    private int inputNumber;
    Scanner scanner = new Scanner(System.in);


    public void start() {
        switch (selectMainMenu()) {
            case (1) -> newContact();
            case (2) -> removeContact();
            case (3) -> printContacts();
            case (4) -> exit();
        }

        start();


    }


    private void printContacts() {

        addressBook.getAllContacts();

    }

    private void removeContact() {
        System.out.println("Введите фамилию, удаляемого контакта");
        String surname = scanner.next();
        addressBook.deleteContactBySurname(surname);

    }

    private void newContact() {
        addressBook.addContact();

    }

    private void exit() {
        System.out.println("Работа программы завершена, ждём вас снова!");
        System.exit(0);

    }

    private int selectMainMenu() {
        while (true) {
            System.out.println("Адресная книга\n");
            System.out.println("1-Новый контакт\n" +
                    "2-Удаление существующего контакта\n" +
                    "3-Вывод всех контактов\n" + "4- Завершение работы");
            System.out.println("Введите нужную опцию и нажмите Enter");
            try {
                inputNumber = scanner.nextInt();
                if (inputNumber >= 1 && inputNumber <= 4) {
                    break;
                } else {
                    System.out.println("Не верная опция, попробуй еще раз");
                }
            } catch (Exception e) {
                System.out.println("Не верная опция, попробуй еще раз");
                scanner.nextLine();
            }

        }

        return inputNumber;
    }
}
