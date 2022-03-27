package 注解;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class 反射获取注解 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("注解.UerController");

        Boolean result = c.isAnnotationPresent(Controller.class);
        System.out.println(result);

        Method method[] = MethodUtils.getMethodsWithAnnotation(c, MethodController.class);
        for (Method m : method) {
            System.out.println(m);
            String MethodName = m.getName();
            System.out.println(MethodName);

            Annotation[] arry = c.getMethod(MethodName).getAnnotations();
            for (Annotation annotation : arry) {
                if (annotation instanceof MethodController) {
                    System.out.println("MethodController 注解是" + arry);
                    System.out.println("name属性" + ((MethodController) annotation).name());
                    System.out.println("age属性" + ((MethodController) annotation).age());
                } else {
                    System.out.println("非MethodController注解" + annotation);
                }
            }
        }
    }
}
