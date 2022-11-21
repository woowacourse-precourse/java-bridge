package bridge;

import java.util.List;
import java.util.Stack;

public class Model {
    public static List<String> bridge;
    public static Stack<String> user = new Stack<>();
    public static String upperResult = "[]";
    public static String lowerResult = "[]"; // ] 를 찾아서 제거하고 공백을 포함한 문자열을 추가, 마지막엔 다시 ]를 추가

    public static int size;
}
