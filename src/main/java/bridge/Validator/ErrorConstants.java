package bridge.Validator;

public class ErrorConstants {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String ERROR_FOR_LENGTH_OF_BRIDGE = ERROR_MESSAGE + " " + "다리의 길이는 3이상 20이하의 숫자만 가능합니다.";
    public static final String ERROR_FOR_UP_OR_DOWN = ERROR_MESSAGE + " " + "위: \"U\", 아래: \"D\"로만 가능합니다.";
    public static final String ERROR_FOR_RETRY_OR_QUIT = ERROR_MESSAGE + " " + "재시도: \"R\", 종료: \"Q\"로만 가능합니다";
}
