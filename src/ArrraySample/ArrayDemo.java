package ArrraySample;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] ns ={1,2,3,4,5};
        // for 循环
        for(int i=0;i<ns.length;i++){
            int n = ns[i];
            System.out.println("n-" + n);
        }
        // for each循环
        for(int n:ns){
            System.out.println("n：" + n);
        }

        // 倒序打印数组元素:
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.println("n=" + ns[i]);
        }
    }
}
