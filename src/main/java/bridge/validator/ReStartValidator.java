package bridge.validator;

public class ReStartValidator {
    private static final String RESTART = "R";
    private static final String STOP = "Q";

    public static void validate(String restartWhether) {
        if (!isEqualRestartMessage(restartWhether) && !isEqualStopMessage(restartWhether)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEqualStopMessage(String restartWhether) {
        return restartWhether.equals(STOP);
    }

    private static boolean isEqualRestartMessage(String restartWhether) {
        return restartWhether.equals(RESTART);
    }
}
