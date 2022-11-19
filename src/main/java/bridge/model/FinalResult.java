package bridge.model;

public class FinalResult {
    private static int attempts = 1;
    private static boolean finalSuccess = false;

    public static void addAttempts() {
        attempts++;
    }
    public static void setFinalSuccess() {
        finalSuccess = true;
    }
    public  static boolean getFinalSuccess() {
        return finalSuccess;
    }
}
