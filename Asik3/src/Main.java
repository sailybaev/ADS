import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        MyHashTable<MyTestingClass , Student> table =  new MyHashTable<MyTestingClass , Student>();
        for(int i=0;i<10000;i++) {
            table.put(new MyTestingClass(generateRandomString(5)) , new Student(generateRandomString(5) , generateRandomString(6)));
        }

        for(int i =0;i<table.getM();i++) {
            System.out.println(table.countElements(i));
        }
    }
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length ; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

}