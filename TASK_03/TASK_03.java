package TASK_03;

import javafx.util.StringConverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class TASK_03 {

    private MyTreeMap<Character, Integer> latters = new MyTreeMap<Character, Integer>();
    private MyTreeMap<Character, Double> relative = new MyTreeMap<Character, Double>();
    private String fileName = "groupFile.csv";

    public static void main(String[] args) {
        TASK_03 task_03 = new TASK_03();
        task_03.count();
    }

    public void count() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            Character character;
            int value;
            Integer amount;
            while ((value = bufferedReader.read()) > 0) {
                character = (char) value;
                if (Character.isLetter(character)) {
                    character = Character.toLowerCase(character);
                    amount = latters.get(character);
                    if (amount == null) {
                        amount = 0;
                    }
                    latters.put(character, amount + 1);
                }
            }
            System.out.println(latters);

            Collection<Integer> values = latters.values();
            int sum = 0;
            for (Integer i : values)
            {
                sum = sum + i;
            }

            Set<Character> characters= latters.keySet();
            for (Character c : characters)
            {
                Double persent = (double) latters.get(c) * 100 / sum;
                relative.put(c, persent);
            }

            System.out.println(relative.toString());

        }
        catch (IOException e) {System.out.println("ERROR");}
    }

}


















