import java.util.*;

/*
Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся имена
с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */
public class Task2 {
    public static void main(String[] args) {
        String nameList = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, \n" +
                "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, \n" +
                "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        countNames(nameList);
    }

    static void countNames(String line) {
        line = line.replace("\n", "");
        line = line.replaceAll("\\p{Punct}", "");
        String[] nameArr = line.split(" ");
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nameArr.length; i += 2) {
            if (hashMap.containsKey(nameArr[i])){
                int num = hashMap.get(nameArr[i]);
                num += 1;
                hashMap.put(nameArr[i], num);
            }else {
                hashMap.put(nameArr[i], 1);
            }
        }

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            int num = entry.getValue();
            if (treeMap.containsKey(num)){
                List<String> list = treeMap.get(num);
                list.add(entry.getKey());
            }else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                treeMap.put(num, list);
            }
        }
        System.out.println(treeMap);
    }
}

