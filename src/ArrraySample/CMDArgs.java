package ArrraySample;

import java.util.Arrays;

public class CMDArgs {
    // 命令行参数
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args)); // [-version]
    }
}

/*
* 命令行之间运行  java TwoArray.java -version
* */