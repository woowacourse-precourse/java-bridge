package bridge;

import java.util.List;
import java.util.Stack;

public class Model {
    public static List<String> bridge; // BridgeMaker에서 조작
    public static Stack<String> user = new Stack<>(); // BridgeGame에서 조작

    public static String upperResult="[";

    public static String lowerResult="[";

    public static int size;
}
