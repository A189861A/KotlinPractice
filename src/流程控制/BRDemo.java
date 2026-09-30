package 流程控制;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BufferedReader（速度更快，大数据输入）

public class BRDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入一行");
        String line = br.readLine();
        // 字符串转数字
        int n = Integer.parseInt(line);
        System.out.println(n);
    }
}
