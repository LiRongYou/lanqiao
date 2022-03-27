package 作业.班级成绩排序;

import java.util.*;

public class Results {
    public static void main(String[] args) {
        List<Student> data = new ArrayList<Student>();
        initData(data);
        adjust(data);
        print(data);
    }

    public static void initData(List<Student> data) {
        for (int i = 0; i < 40; i++) {
            int id = 180201 + i;
            String name = "同学" + i;
            Random ran = new Random();
            int score = 50 + ran.nextInt(50);
            Student student = new Student(name, id, score);
            data.add(student);
        }
    }

    public static void adjust(List<Student> data) {
        Collections.sort(data);
    }

    public static void print(List<Student> data) {
        Iterator<Student> it = data.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
