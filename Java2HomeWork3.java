import java.util.HashMap;
import java.util.Map;

public class Java2HomeWork3 {
    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {
        String[] words = {"apple", "mango", "cat", "dog", "robot", "phone", "car", "plane",
                "notebook", "water", "cat", "dog", "phone", "plane", "plane", "plane", "notebook", "avocado"};
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String mapKey = words[i];
            Integer mapValue = map.get(mapKey);
            if (mapValue == null) map.put(mapKey, 1);
            else map.put(mapKey, mapValue + 1);
        }
        System.out.println(map);
    }

    static void task2() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "12345");
        phonebook.add("Петров", "23456");
        phonebook.add("Сидоров", "34567");
        phonebook.add("Иванов", "45678");
        System.out.println(phonebook.get("Иванов"));
        phonebook.printPhonebook();

    }

}
