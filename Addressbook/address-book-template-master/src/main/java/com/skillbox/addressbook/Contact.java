package main.java.com.skillbox.addressbook;

import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter


public class Contact  {
    private  int id=1;
    private int nextId=1;
    private  String name;
    private  String surname;
    private Date birthday;
    private String email;
    private  String phoneNumber;
    private String post;

    public Contact(String name, String surname, Date birthday, String email, String phoneNumber, String post) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.post = post;
        id=nextId;
        nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return this.name== contact.name && this.surname== contact.surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Имя:"+name +"\nФамилия:"+surname +"\nДата рождения:"+birthday+"\nemail:"+email+
                "\nТелефон:"+phoneNumber+ "\nДолжность:"+post;
    }

}


// Опишите тут необходимые поля и методы доступа к этим полям.
    // Переопределите конструктор по умолчанию, методы hashCode() и equals()
    // Будет удобно, если вы также переопределите метод toString() для
    // вывода информации о контакте

