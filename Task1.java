/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Task1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPerson("Иванов Иван", 123);
        phoneBook.addPerson("Петров Петр", 456);
        phoneBook.addPerson("Юрьев Юрий", 789);
        phoneBook.addPerson("Юрьев Юрий", 753);

        System.out.println(phoneBook.printAllBook());
        System.out.println(phoneBook.findName(789));
        System.out.println(phoneBook.findNumber("Петров Петр"));
    }
}