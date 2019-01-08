import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Zadanie_1 {

    public Zadanie_1(String[] z) {
        /*
        Задание 1
        */

        HashMap<String, Integer> result = new HashMap();

        System.out.println("Всего слов в переданном массиве : " + z.length);

        for (int i = 0; i < z.length; i++) {
            int a = 0;
            for (int j = 0; j < z.length; j++) { if (z[i].equals(z[j])) { a++; } }
            result.put(z[i], a);
        }

        Iterator<HashMap.Entry<String, Integer>> iterator = result.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();
            Integer value = pair.getValue();

            System.out.println("Слово : ( " + key + " ) Встретилось в переданном массиве : " + value + " раз(а)");
        }
    }
}
