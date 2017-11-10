package TASK_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task01 {

    public static void main (String[] args)
    {
        Task01 task01 = new Task01();
        task01.run();
    }

    ArrayList<String> words = new ArrayList<>();

    public void run (){
        words.add("word01");
        words.add("word02");
        words.add("word03");
        words.add("word04");
        words.add("word05");
        words.add("word06");
        words.add("word07");
        words.add("word08");
        words.add("word09");
        words.add("word10");
        System.out.println(words);

        words.remove(0);
        int length = words.size();
        words.remove(length - 1);
        words.remove(length - 2);
        System.out.println(words);
    }
}
