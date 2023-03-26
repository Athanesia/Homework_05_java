// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.*;

public class Main_02 {
    public static void main(String[] args) {
        String[] names = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
                          "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                          "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                          "Иван Мечников", "Петр Петин", "Иван Ежов"};

        Map<String, Integer> nameCounts = new HashMap<>();

        for (String name : names) {
            if (nameCounts.containsKey(name)) {
                nameCounts.put(name, nameCounts.get(name) + 1);
            } else {
                nameCounts.put(name, 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedNameCounts = new ArrayList<>(nameCounts.entrySet());
        Collections.sort(sortedNameCounts, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : sortedNameCounts) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " раз(а)");
            }
        }
    }
}