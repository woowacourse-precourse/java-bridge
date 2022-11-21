package bridge.domain.oxbridgebuilder;

public class OXBridgeUtils {

    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    public static final String SPACE = " ";

    public static String makeOX(boolean correctOrWrong) {
        if (correctOrWrong) {
            return CORRECT;
        }
        return WRONG;
    }
}
