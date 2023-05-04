import java.util.*;

public class PhoneBook {
    private static HashMap<String, List<Integer>> map = new HashMap<>();

    void addPerson(String name, int number) {
        if (map.containsKey(name)) {
            List<Integer> list = map.get(name);
            list.add(number);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(number);
            map.put(name, list);
        }
    }

    String printAllBook() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append(": ");
            List<Integer> list = (List<Integer>) entry.getValue();
            for (int num : list) {
                stringBuilder.append(num + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    String findName(int num) {
        Iterator mapIterator = map.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        {
            while (mapIterator.hasNext()) {
                    Map.Entry<String, List<Integer>> entry = (Map.Entry<String, List<Integer>>) mapIterator.next();
                    List<Integer> list = entry.getValue();
                    if (list.contains(num)) {
                    stringBuilder.append(entry.getKey());
                    stringBuilder.append(": ");
                    for (int number : list) {
                        stringBuilder.append(number + " ");
                    }
                    stringBuilder.append("\n");
                    return stringBuilder.toString();
                }
            }
        }
        return "Такого номера нет";
    }

    String findNumber(String name) {
        Iterator mapIterator = map.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        {
            while (mapIterator.hasNext()) {
                Map.Entry<String, List<Integer>> entry = (Map.Entry<String, List<Integer>>) mapIterator.next();
                if (entry.getKey().equals(name)) {
                    List<Integer> list = entry.getValue();
                    stringBuilder.append(entry.getKey());
                    stringBuilder.append(": ");
                    for (int number : list) {
                        stringBuilder.append(number + " ");
                    }
                    stringBuilder.append("\n");
                    return stringBuilder.toString();
                }
            }
        }
        return "Такого контакта нет";
    }
}



