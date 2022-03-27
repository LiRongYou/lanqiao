package 反射机制;


public class Test {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "efgh";
        String str3 = str1 + str2;

        Integer age = 30;//装箱：简写（减少程序员工作量）

        int a = age;//拆箱：减轻程序员工作量

        //int a=age.intValue();
        //debug

        Student stu = new Student();
    }
}
