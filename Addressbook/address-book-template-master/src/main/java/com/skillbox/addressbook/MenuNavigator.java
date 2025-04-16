package main.java.com.skillbox.addressbook;

import java.util.Scanner;

public class MenuNavigator {
    AddressBook addressBook = new AddressBook();
    Contact contact;
    private int inputNumber;

    // Определите тут необходимые поля.
    // Уверены, вам точно потребуется поле типа AddressBook.

    public void start() {
        selectMainMenu();
        // Напишите тут ваш код для вывода основного меню и
        // ввода выбора пользователя.
        // Советуем для каждого пункта меню написать свой метод,
        // заготовки для этих методов мы оставили для вас ниже.
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
        // Здесь будет код для добавления нового контакта
    }

    private void exit() {
        // Здесь будет код для выхода из программы
    }

    private int selectMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Адресная книга\n");
            System.out.println("1-Новый контакт\n" +
                    "2-Удаление существующего контакта\n" +
                    "3-Вывод всех контактов\n" + "4- Завершение работы");
            System.out.println("Введите нужную опцию и нажмите Enter");
            try {
                inputNumber = scanner.nextInt();
                if (inputNumber >= 1 && inputNumber <= 4) {
                    break; // выход из цикла, если введено валидное значение
                } else {
                    System.out.println("Не верный ввод");
                }
            } catch (Exception e) {
                System.out.println("Не верный ввод");
                scanner.next();
            }
        }
        // Здесь будет код для вывода основного меню и получения выбора
        // пользователя.
        // Метод должен вернуть номер опции, выбранной пользователем
        return inputNumber;
    }
}
