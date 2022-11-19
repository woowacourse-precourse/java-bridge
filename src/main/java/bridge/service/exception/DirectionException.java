package bridge.service.exception;

public class DirectionException {

    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private static final String NOT_CORRECT_FORMAT_ERROR_MESSAGE = "U와 D중 하나만 선택할 수 있습니다.";
    private static final String COLLECT_FORMAT = "UD";

    public static void checkMovingIsCorrectFormat(String move) {
        if (!COLLECT_FORMAT.contains(move)) {
            throw new IllegalArgumentException(START_ERROR_MESSAGE + NOT_CORRECT_FORMAT_ERROR_MESSAGE);
        }
    }
}
