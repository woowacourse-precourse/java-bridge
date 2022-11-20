package bridge.domain;

public class BridgeStage {
    private static int stage = 0;

    public static void nextStage() {
        stage++;
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
