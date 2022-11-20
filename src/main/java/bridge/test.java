package bridge;


import java.util.ArrayList;
import java.util.List;

public class test {
    public static List<String> str = new ArrayList<>();

    public static void main(String[] args) {

        boolean game = true;
        test t = new test();
        int count = 0;
        int result = 0;
        while(game) {

           testList();

            System.out.println(result);
            result++;
            if (result == 3) {
                game = false;
            }
        }
    }


    public static void testList() {
        str.add("hi");
        for (String s : str) {
            System.out.println(s);
        }
    }
}
