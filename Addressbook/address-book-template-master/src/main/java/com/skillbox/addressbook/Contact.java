package main.java.com.skillbox.addressbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Contact {
    private int id = 1;
    private int nextId = 1;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private String post;

    public Contact(String name, String surname, String patronymic, LocalDate birthday, String email, String phoneNumber, String post) {
        this.name = name.toLowerCase();
        this.patronymic = patronymic.toLowerCase();
        this.surname = surname.toLowerCase();
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.post = post.toLowerCase();
        id = nextId++;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Фамилия:" + surname.toUpperCase() + "\nИмя:" + name.toUpperCase() + "\nОтчество:" + patronymic.toUpperCase() + "\nИмя:" + name.toUpperCase() + "\nДата рождения:" + birthday + "\nemail:" + email +
                "\nТелефон:" + phoneNumber + "\nДолжность:" + post;
    }

}


// Опишите тут необходимые поля и методы доступа к этим полям.
// Переопределите конструктор по умолчанию, методы hashCode() и equals()
// Будет удобно, если вы также переопределите метод toString() для
// вывода информации о контакте

