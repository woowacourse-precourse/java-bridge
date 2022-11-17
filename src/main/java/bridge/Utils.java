package bridge;

public class Utils {
    private static final String CROSS_SUCCEEDED = "O";
    private static final String CROSS_FAILED = "X";

    public String checkCrossability(String answerBridge, String usersSelection) {
        if (answerBridge.equals(usersSelection)) {
            return CROSS_SUCCEEDED;
        }
        return CROSS_FAILED;
    }

}
