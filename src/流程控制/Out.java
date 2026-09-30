package 流程控制;

public class Out {
    public static void main(String[] args) {
        int age = 25;
        double score = 92.567;
        String name = "张三";
/*
格式：printf(格式串, 参数...)
     println()：输出 + 自动换行
     print()：输出不换行

    占位符	说明	            示例
    %d	    十进制整数	    %5d 占 5 字符宽度，右对齐
    %f	    浮点数	        %.2f 保留 2 位小数
    %s	    字符串	        %10s 右对齐占 10 位
    %n	    换行            跨平台，推荐，不要用 \n）
    %b	    布尔值
    %x	    十六进制整数
* */
        // %d 整数，%s字符串，%f浮点数
        System.out.printf("姓名：%s，年龄：%d，分数：%.2f%n", name, age, score);
        // 输出：姓名：张三，年龄：25，分数：92.57

        int sum = 0;
        int i;
        /*
        for (初始条件; 循环检测条件; 循环后更新计数器) {
            // 执行语句
        }
        * */
        for ( i=1; i<=5; i++) {
            System.out.println(i);
            if(i == 3) {
//                break; // 退出循环
                continue; // 结束本次循环，继续执行下次循环
            }
            sum = sum + i;
        }
        System.out.println("i=" + i); // 6
        System.out.println(sum);
    }
}
