import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderSample {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下 q 键退出");
//        do {
//            c = (char) br.read();
//            System.out.println("sout:" + c);
//        } while (c != 'q');

        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
}
