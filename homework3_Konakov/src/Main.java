import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Делаем задание 1
        String [] z = {"снегокат" , "горки" , "тюбинг" , "санки" , "перчатки" , "глинтвейн" , "коньки" , "зима" , "снеговик" , "ледянка" , "Новый год" , "рождество" , "каникулы" , "праздники", "горки"
                , "тюбинг" , "санки" , "перчатки" , "глинтвейн"};
       Zadanie_1 z1 = new Zadanie_1(z);

       // Делаем задание 2
        System.out.println("");
        System.out.println("Далее переходим к заданию № 2");

        String [] name = {"Иванов" , "Петров" , "Сидоров" , "Конаков" , "Осипено" };
        int [] nomera = { 123 , 456 , 789 , 101 , 151};

        Zadanie_2 z2 = new Zadanie_2(name,nomera) ;





    }
}
