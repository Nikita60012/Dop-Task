import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Student st = new Student();
        int[] marks = new int[5];
        List<Student> list = new ArrayList<Student>();
        boolean exit = false;
        System.out.println("Введите данные студентов (Фамилия и инициалы, номер группы, оценки в количестве 5 штук)");
        System.out.println("Или введите exit для завершения ввода данных");
        while(!exit){
            Scanner input = new Scanner(System.in);

            String name = input.nextLine();
            if(name.equals("exit")){
                exit = true;
                break;
            }
            int group = input.nextInt();
            for(int i = 0; i < marks.length; i++){
                marks[i] = input.nextInt();
            }
            list.add(st = new Student(name, group, marks));
            input.reset();
            System.out.println("Студент добавлен");
        }
        // Проверка работоспособности
        /*
        marks = new int[]{5,4,4,5,5};
        list.add(st = new Student("Иванов Н.М.", 2017, marks));
        marks = new int[]{3, 5, 5, 4, 3};
        list.add(st = new Student("Шадрин Д.А.", 2020, marks));
        marks = new int[]{3, 3, 2, 4, 3};
        list.add(st = new Student("Урсу А.А.", 2010, marks));
        marks = new int[]{5, 3, 2, 3, 3};
        list.add(st = new Student("Вахрушев Н.А.", 2019, marks));
        marks = new int[]{5, 5, 4, 5, 4};
        list.add(st = new Student("Мартынов М.А.", 2023, marks));
         */
        list = Sort.marksSorting(list);
        for(Student output : list){
            System.out.println(output.name + " " + output.group + " " + Arrays.toString(output.marks));
        }
        int[] goodStudents = Sort.findGoodMarks(list);
        System.out.println("Введите + если хотите получить список студентов, оценки которых 4 и 5");
        if("+".equals(in.nextLine())){
            for (int i : goodStudents){
                Student output = list.get(i);
                System.out.println(output.name + " " + output.group);
            }
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
    public static int[] findGoodMarks(List<Student> list){
        int goodNumbers = 0;
        for(int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            int[] marks = st.marks;
            boolean good = true;
            for(int j : marks){
                if(j <= 3){
                    good = false;

                }
            }
            if(good){
               goodNumbers++;
            }
        }
        int[] goodStudents = new int[goodNumbers];
        goodNumbers = 0;

        for(int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            int[] marks = st.marks;
            boolean good = true;
            for (int j : marks) {
                if (j <= 3) {
                    good = false;

                }
            }
            if (good) {
                goodStudents[goodNumbers] = i;
                goodNumbers++;
            }
        }
        return goodStudents;
    }
}