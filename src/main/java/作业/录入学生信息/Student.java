package 作业.录入学生信息;


import java.util.Objects;

public class Student {
    // 两个属性
    private String name;
    private String age;

    // 提供构造方法
    public Student() {
        name ="";
        age ="0";
    }
    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    // 提供 get/set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // 重写 toString、hashCode、equals 方法

    @Override
    public String toString() {
        return "Student: name = "+name+", grade = "+age;

    }

//    @Override
//    public int hashCode() {
//        int result = 0;
//        result = result * 31 + name.hashCode();
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        // 如果 obj 参数为 null 时，无须比较，直接返回 false 即可。
//        if(obj == null){
//            return false;
//        }
//        // 如果当前对象和 obj 的内存地址相同，则二者必然指向同一个对象，因此返回 true 即可。
//        if(this == obj){
//            return true;
//        }
//        // 如果当前对象和 obj 参数对象的类型不一致，也无须比较，直接返回 false 即可。
//        if(this.getClass() != obj.getClass()){
//            return false;
//        }
//        // 如果当前对象和 obj 的所有属性（这里值 name 和 oil ）都相同，也认为二者的比较结果为 true
//        if (obj instanceof Student) {
//            Student student = (Student) obj;
//            //用传入的obj，和当前对象this比较
//            if (this.name.equals(student.getName()) && this.age == student.getAge()) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
