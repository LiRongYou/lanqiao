package 作业.录入学生信息;

import java.util.*;

public class StudentService {
    public static void main(String[] args) {

        Student s1 = new Student("张三","一年级");
        Student s2 = new Student("李四","二年级");
        Student s3 = new Student("小桃子","三年级");
        Student s4 = new Student("张三","一年级");

        Set<Student> student = new HashSet<Student>();
//        ArrayList<Student> student = new ArrayList<>();//这里运用了泛型的思想
        student.add(s1);
        student.add(s2);
        student.add(s3);
        student.add(s4);

        if(addStudent(student)){
            System.out.println("学生信息录入成功");
            showStudent(student);
        }else {
            System.out.println("学生信息录入失败");
        }
    }
    // 录入学生信息
    public static boolean addStudent(Set<Student> student){
        if(student.size()>0){
            return true;
        }else {
        return false;
        }
    }
    // 显示学生信息
    public static void showStudent(Set<Student> student){
        for (Student obj : student) {
            System.out.println(obj.toString());
        }
    }
}