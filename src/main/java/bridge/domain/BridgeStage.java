package bridge.domain;

public class BridgeStage {
    private static int stage = 0;
    private static int retry = 1;

    public static void nextStage() {
        stage++;
    }

    public static void increaseRetry() {
        retry++;
    }

    public static int getRetry() {
        return retry;
    }

    public static int currentStage() {
        return stage;
    }

    public static void resetStage() {
        stage = 0;
    }

    public static boolean isFinalStage(int bridgeSize) {
        if ((bridgeSize - 1) == stage) {
            return true;
        }

        return false;
    }
}
