/**
 * @作者 黎荣右
 * @时间 2021/11/22 21:19
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    String className = ConfigReader.getClassName();
    Animal animal = (Animal)Class.forName(className).newInstance();
    animal.jiao();
    }
}
