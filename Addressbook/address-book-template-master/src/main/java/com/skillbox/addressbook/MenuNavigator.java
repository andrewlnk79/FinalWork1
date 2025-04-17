package main.java.com.skillbox.addressbook;

import java.util.Scanner;

public class MenuNavigator {
    AddressBook addressBook = new AddressBook();
    Contact contact;
    private int inputNumber;
    Scanner scanner = new Scanner(System.in);

    // Определите тут необходимые поля.
    // Уверены, вам точно потребуется поле типа AddressBook.

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
        // Здесь будет код для вывода списка контактов
    }

    private void removeContact() {
        addressBook.deleteContactBySurname("петров");
        // Здесь будет код для удаления контакта
    }

    private void newContact() {
        addressBook.addContact();
        // Здесь будет код для добавления нового контакта
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
                scanner.next();
            }

        }

        return inputNumber;
    }
}
