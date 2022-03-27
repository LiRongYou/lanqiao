package 反射机制.获取指定类的方法信息;

public class User {
    private int ID = 10001;
    int age = 22;
    protected String username = "张三";
    public String password = "123456";

    private void userPrivate() {
    }

    int getAge() {
        return age;
    }

    protected String userProtected() {
        return username;
    }

    public String userPublic() {
        return password;
    }
}
