package HomeWork.HomeWork5;
    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 
{

    // Реализуйте структуру телефонной книги 
    // с помощью HashMap, учитывая, что 1 человек
    // может иметь несколько телефонов.
    public static void main(String[] args) 
    {
        Map<String, List<String>> book = new HashMap<>();
        book.put("Ivan", List.of("8 927 555 77 77", "8 965 425 85 65"));
        book.put("Alex", List.of("8 937 856 85 56", "8 917 456 54 58"));
        book.put("Max", List.of("8 954 247 55 38", "8 927 852 21 23"));

        menu(book);
    }

    public static String scan() // Конструкция позволяет избежать ошибок!
    {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close(); // если закрыть то не работает !
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook)
    // Поиск абонента
    {
        System.out.print("Имя абонента: ");
        String name = scan();
        System.out.println("Имя: "+ name +"\nТелефон(ы): "+ phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> AllBook) 
    // Печать книги
    {
        for (var item : AllBook.entrySet()) 
        {
            System.out.println("Имя: " + item.getKey() + "\nНомер" + item.getValue());
        }
    }

    public static Map<String, List<String>> add(Map<String, List<String>> book) 
    // Добавление в тел. книгу
    {
        System.out.print("Имя абонента: ");
        String name = scan();
        List<String> data = new ArrayList<>();
        while (true) {
            System.out.println("Если номеров больше нет, введите '5'");
            System.out.print("Введите номер: ");
            String nomer = scan();
            if (nomer.equals("5")) {
                break;
            } else {
                data.add(nomer);
            }
        }
        book.put(name, data);

        return book;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> book) {
        while (true) {
            System.out.println( "    --------------\n   Телефонная Книга\n    --------------\n" +
                "        Меню: \n1. Найти контакт \n2. Добавить контакт"+
                " \n3. Печать телефонной книги \n4. Выход");
            System.out.print("\nвыберите пункт меню-> ");
            String comands = scan();
            if (comands.equals("4")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        find(book);
                        break;
                    case "2":
                        add(book);
                        break;
                    case "3":
                        allBook(book);
                        break;
                    default:
                        break;
                }
            }
        }
        return book;
    }
}
