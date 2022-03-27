package Dom4j的使用;


import java.util.ArrayList;
import java.util.List;
/**
 * 人员信息类
 */
public class Person {
    private String id;
    private String name;
    private String sex;
    private int age;

    public Person() {
    }

    public Person(String id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /**
     * 获取人员信息列表
     * @return Person 集合
     */
    public static List<Person> getPersons(){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("1001", "何学浩", "男", 21));
        list.add(new Person("1002", "钟丁豪", "男", 22));
        list.add(new Person("1003", "黎香香", "女", 21));
        list.add(new Person("1004", "廖仙娇", "女", 22));
        return list;
    }
}
