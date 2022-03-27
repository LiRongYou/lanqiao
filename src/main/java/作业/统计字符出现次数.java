package 作业;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 统计字符出现次数 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = input.next();
        statis(str);

    }
    public static Map statis (String string){
        String a=string.replaceAll("[^a-zA-Z]", "");
        // String []str = new String[a.length()];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {

            char ch = a.charAt(i);

            if (map.containsKey(ch)) {
                int count = map.get(ch);
                count = count + 1;
                map.put(ch, count);
            } else {
                map.put(ch, 1);
            }
        }
         	// 遍历map集合
         	Set<Character> keySet = map.keySet();
         	for (Character chars : keySet) {
                System.out.println(chars + "=" + map.get(chars));
            }
        return map;
    }
}
