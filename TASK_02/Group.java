package TASK_02;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Роман on 15.10.2017.
 */
public class Group implements Voenkom, Serializable {
    private ArrayList<Student> students = new ArrayList<>();
    private String groupFile = "groupFile.csv";

    public void addStudent(Student student) throws NoSpace {
        if (students.size() == 10) {
            throw new NoSpace();
        }
        students.add(student);

    }

    public Integer searchStudent(String name) {
        int position = 0;

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return position;
            }
            position++;
        }
        return null;
    }

    public void removeStudent(int i) {
        students.remove(i);
    }

    public void selfPrintAlph() {
        ArrayList<Student> sorted = (ArrayList<Student>) students.clone();
        boolean swapped = true;
        Integer i, j;
        while (swapped) {
            swapped = false;
            for (i = 0, j = 1; j < sorted.size(); i++, j++) {
                int comp = sorted.get(i).getName().compareTo(sorted.get(j).getName());
                if (comp <= 0) {
                } else if (comp > 0) {
                    Student temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                    swapped = true;
                }
            }
        }

        int q = 0;
        for (Student student : sorted) {
            if (student == null) {
                return;
            }
            System.out.println(q + ". " + student.getName());
            q++;
        }

    }

    public void printSelf() {
        int i = 0;
        for (Student student : students) {
            System.out.print(i + ". ");
            if (student == null) {
                System.out.println("empty");
            } else {
                System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getMark());
            }

            i++;
        }
    }

    public void printSelf(ArrayList<Student> students) {
        int i = 0;
        for (Student student : students) {
            System.out.print(i + ". ");
            if (student == null) {
                System.out.println("empty");
            } else {
                System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getMark());
            }
            i++;
        }
    }

    public void sort(String parameter) {
        ArrayList<Student> sorted = (ArrayList<Student>) students.clone();
        boolean swapped = true;
        Integer comp = null;
        int i;
        int j;
        while (swapped) {
            swapped = false;
            for (i = 0, j = 1; j < sorted.size(); i++, j++) {
                if (parameter.equals("name")) {
                    comp = sorted.get(i).getName().compareTo(sorted.get(j).getName());
                } else if (parameter.equals("mark")) {
                    comp = sorted.get(i).getMark().compareTo(sorted.get(j).getMark());
                } else {
                    System.out.println("INCORRECT PARAMETER!");
                    return;
                }
                if (comp <= 0) {
                } else if (comp > 0) {
                    Student temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                    swapped = true;
                }
            }
        }
        students = sorted;
    }

    @Override
    public ArrayList<Student> get18() {
        int count = 0;

        ArrayList<Student> only18 = new ArrayList<>();
        int i = 0;
        for (Student student : students) {
            if (student.getAge() >= 18) {
                only18.add(student);
            }
        }
        return only18;
    }

    public void writeToFile() {
        File file = new File(groupFile);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (Student student : students) {
                if (student != null) {
                    printWriter.print(student.getName() + "\t");
                    printWriter.print(student.getAge() + "\t");
                    printWriter.print(student.getMark());
                    printWriter.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        File file = new File(groupFile);
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<Student> redList = new ArrayList<>();
            String input;
            for (int i = 0; i < 10; i++) {
                if (!scanner.hasNext()) {
                    break;
                } else if ((input = scanner.next()) == "\n") {
                    break;
                }
                Student student = new Student();
                student.setName(input);
                student.setAge(Integer.parseInt(scanner.next()));
                student.setMark(Integer.parseInt(scanner.next()));
                redList.add(student);
            }
            students = redList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void serialize(String fileName) throws IOException {
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(fileName))) {
            OOS.writeObject(students);
        }
    }

    public void deserialize(String fileName) {
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (ArrayList<Student>) OIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR load group !!!");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}


class NoSpace extends Exception {
    @Override
    public String getMessage() {
        return "GROUP IS FULL!";
    }
}