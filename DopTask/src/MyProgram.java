import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Student st = new Student();
        int[] marks ={5,4,4,5,5};
        List<Student> list = new ArrayList<Student>();
        list.add(st = new Student("Иванов Н.М.", 2017, marks));
        marks = new int[]{3, 5, 5, 4, 3};
        list.add(st = new Student("Шадрин Д.А.", 2020, marks));
        marks = new int[]{3, 3, 2, 4, 3};
        list.add(st = new Student("Урсу А.А.", 2010, marks));
        marks = new int[]{5, 3, 2, 3, 3};
        list.add(st = new Student("Вахрушев Н.А.", 2019, marks));
        list = Sort.marksSorting(list);
        for(Student output : list){
            System.out.println(output.name + " " + output.group + " " + Arrays.toString(output.marks));
        }
    }
}

class Student{
    public   String name;
    public int group;
    public int[] marks = new int[5];
    Student(){
    }
    Student(String name, int group, int[] marks){
        this.name = name;
        this.group = group;
        this.marks = marks;
    }
}
class Sort{
    public static List<Student> marksSorting(List<Student> list){
        List<Student> listSort = list;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 1; i < listSort.size(); i++) {
                Student st = listSort.get(i);
                int[] marks = st.marks;
                double average = 0;
                for (int j : marks) {
                    average += j;
                }
                average /= 5;

                int k = i - 1;
                Student st2 = listSort.get(k);
                int[] marks2 = st2.marks;
                double average2 = 0;
                for (int j : marks2) {
                    average2 += j;
                }
                average2 /= 5;

                if (average < average2) {
                    listSort.set(k, st);
                    listSort.set(k+1, st2);
                    sorted = false;
                }
            }
        }
        return listSort;
    }
    public int[] findGoodMarks(List<Student> list){
        int[] goodStudents;
        Student.
        int[] marks = list
        if()
        return
    }
}