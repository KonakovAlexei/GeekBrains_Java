import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Zadanie_2 {
    /*
    Задание 2
    */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public Zadanie_2(String[] name, int[] nomera) throws IOException {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(nomera[i], name[i]);
        }
        start(map);
    }
     public void start(HashMap<Integer, String> map) throws IOException {

        System.out.println("Вы находитесь в меню телефонного справочника.");
         System.out.println(" Какое из возможных действий вы хотите выполнить : 1. Добавить запись (введите 1) / 2. Посмотреть номер абонента (введите 2) / 3. вывести весь телефонный справочник (введите 3) ?");
         String z = reader.readLine();
         if (z.equals("1")) {
             add(map);
         } else if (z.equals("2")) {
             get(map);
         } else if (z.equals("3")) {
             print(map);
         } else {
             System.out.println("Вы неправильно ввели команду, перезапустите программу");
             System.exit(0);
         }
     }

    public void add(HashMap<Integer, String> map) throws IOException {
        System.out.println("Введите фамилию нового абонента");
    String name = reader.readLine();
        System.out.println("Введите телефонный номер нового абонента");
    int nomer = Integer.parseInt(reader.readLine());
        map.put(nomer , name);
        System.out.println("Новый абонент сохранен в Телефонной книжке ! Далее возвращаемся в меню.");

        start(map);
    }

    public void get(HashMap<Integer, String> map) throws IOException {
        System.out.println("Введите фамилию абонента : ");
        String name = reader.readLine();

        Iterator<HashMap.Entry<Integer, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, String> pair = iterator.next();
            String value = pair.getValue();
            Integer key = pair.getKey();
            if (value.contains(name)) {System.out.println("По абоненту " + name + " числится следующий номер(а) : " + key);}
        }
        System.out.println("Информация предоставлена, возвращаемся в меню.");
        start(map);

    }
    public void print(HashMap<Integer, String> map) throws IOException {
        Iterator<HashMap.Entry<Integer, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> pair = iterator.next();
            String value = pair.getValue();
            Integer key = pair.getKey();

            System.out.println("Фамилия : ( " + value + " ) Номер : " + key + " . ");
        }
        System.out.println("Телефонный справочник распечтан! возврат в меню.");
        start(map);
    }

}
