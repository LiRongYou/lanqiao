package IO流.将对象输出到文件里;

public class Student {
    private String name;
    private int age;

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public Student(){}

    public Student(String name,int age ){
        this.name = name;
        this.age = age;
    }
}