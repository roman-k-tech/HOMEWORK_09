package TASK_04;

import java.util.ArrayDeque;

public class TASK_04 {

    public static void main(String[] args) {
        TASK_04 task_04 = new TASK_04();
        task_04.run(10);
    }

    private ArrayDeque<String> queue = new ArrayDeque<>();

    public TASK_04() {

        String Sheldon = "Sheldon";
        String Leonard = "Leonard";
        String Volovitc = "Volovitc";
        String Kutrapalli = "Kutrapalli";
        String Penny = "Penny";

        queue.add(Sheldon);
        queue.add(Leonard);
        queue.add(Volovitc);
        queue.add(Kutrapalli);
        queue.add(Penny);
    }

    public void run(int i) {
        String item;
        for (; i > 0; i--) {
            item = queue.pollFirst();
            queue.offerLast(item);
            queue.offerLast(item);
        }

        for (String name : queue) {
            System.out.println(name);
        }
    }
}
