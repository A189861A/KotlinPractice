package 流程控制;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         Scanner 坑：nextInt() 之后直接 nextLine() 会读到空字符串（残留换行符）。
         解决：读完数字后额外 sc.nextLine(); 吃掉换行。
        * */
        System.out.println("输入整数：");
        int n = sc.nextInt();

        System.out.println("输入小数：");
        double d = sc.nextDouble();

        System.out.println("输入字符串：");
        String s = sc.next(); // next()读到空格就停止

        // nextLine() 读取一整行（包含空格）
        // String line = sc.nextLine();

        System.out.printf("你输入：%d , %.2f , %s%n", n, d, s);
        sc.close();
    }
}
