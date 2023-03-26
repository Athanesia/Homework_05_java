// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookDemo_01 {
    private Map<String, List<String>> phoneBook;

    public PhoneBookDemo_01() {
        this.phoneBook = new HashMap<>();
        initializePhoneBook();
    }

    private void initializePhoneBook() {
        addPhone("Иванов", "123-45-67");
        addPhone("Иванов", "890-12-34");
        addPhone("Петров", "456-78-90");
        addPhone("Сидоров", "555-55-55");
    }

    public void addPhone(String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public List<String> getPhones(String name) {
        return phoneBook.get(name);
    }

    public void printPhoneBook() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    public static void main(String[] args) {
        PhoneBookDemo_01 phoneBook = new PhoneBookDemo_01();
        phoneBook.printPhoneBook();
    }
}