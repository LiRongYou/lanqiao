package 作业.模拟一个图书馆;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        // 创建集合对象，用于存储学生数据
        ArrayList<Book> book = new ArrayList<Book>();
        // 主界面
        while (true) {
            System.out.println("——————欢迎来到荣右图书馆——————");
            System.out.println("1.添加图书");
            System.out.println("2.查询图书");
            System.out.println("3.删除图书");
            System.out.println("4.退出程序");
            System.out.println("请输入选项：");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    addBook(book);
                    break;
                case 2:
                    selectBook(book);
                    break;
                case 3:
                    deleteBook(book);
                    break;
                case 4:
                    System.out.println("感谢使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入指令错误");

            }
        }
    }
    // 添加图书
    public static void addBook(ArrayList<Book> book) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入图书id：");
        int id = sc.nextInt();

        System.out.println("请输入书名：");
        String name = sc.next();

        System.out.println("请输入作者名：");
        String author = sc.next();

        System.out.println("请输入价格：");
        double price = sc.nextDouble();

        Book b = new Book();
        b.setId(id);
        b.setName(name);
        b.setAuthor(author);
        b.setPrice(price);

        book.add(b);
        if(book.equals(b)){
            System.out.println("添加失败");
        }else {
            System.out.println("添加成功");
        }
    }
    // 查看图书
    public static void selectBook(ArrayList<Book> book) {
        // 判断集合中是否有数据
        if (book.size() == 0) {
            System.out.println("无信息，请先添加信息后再查看信息");
        } else {
            // 显示表头信息 \t就是tab键
            System.out.println("以下为所有图书信息！");
            System.out.println(book.toString());
        }
    }
    // 删除图书
    public static void deleteBook(ArrayList<Book> book) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的图书id：");
        int id = sc.nextInt();

//        if(book.contains(id)){
//            book.remove(id);
//            System.out.println("删除成功");
//        }else {
//            System.out.println("没有找到你要删除的图书");
//        }
        for (int i = 0; i < book.size(); i++) {
            Book b = book.get(i);
            if (b.getId()==id) {
                book.remove(i);
                System.out.println("删除成功");
                break;
            }else {
                System.out.println("没有找到你要删除的图书");
            }
        }
    }
}


