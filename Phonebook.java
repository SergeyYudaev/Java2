
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();

    public void add(String name, String telNumber) {
        ArrayList<String> numbers = phonebook.get(name);
        if (numbers == null) numbers = new ArrayList<String>();
        numbers.add(telNumber);
        phonebook.put(name, numbers);
    }

    public ArrayList<String> get(String name) {
        return phonebook.get(name);
    }

    public void printPhonebook() {
        System.out.println(phonebook);
    }


}
