package 注解;

@Controller
public class UerController {

    @MethodController(name = "张三", age = 10)
    public String test() {
        return "";
    }

    public void test1() {
        System.out.println("注解");
    }
}
