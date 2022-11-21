package bridge;


import java.util.ArrayList;
import java.util.List;

public class test {
    public static String test = "[ ";
    public static void main(String[] args) {
        test += "hi";
        test += " ]";
        System.out.println(test);

        test = "";
        System.out.println(test);
    }
}
