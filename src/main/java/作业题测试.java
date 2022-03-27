
public class 作业题测试{
    public static void main(String[] args) {
        int a[] = { 0, 1, 2, 3, 4 };
        int sum = 0;
        try {
            for (int i = 0; i < 6; i++) {
                sum += a[i];
            }
            System.out.print(sum);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.print(" 数组下标越界");
        } finally {
            System.out.print(" 程序结束");
        }
    }
}
