package bridge.Validator.Constants;

import static bridge.View.Constants.InputConstants.*;

public class ErrorConstants {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String ERROR_FOR_LENGTH_OF_BRIDGE = ERROR_MESSAGE + " " + "다리의 길이는 " + MIN_VALUE_LENGTH_OF_BRIDGE + "부터 " + MAX_VALUE_LENGTH_OF_BRIDGE + " 사이의 숫자만 가능합니다.";
    public static final String ERROR_FOR_UP_OR_DOWN = ERROR_MESSAGE + " " + "위: " + UP + ", 아래: " + DOWN + "로만 가능합니다.";
    public static final String ERROR_FOR_RETRY_OR_QUIT = ERROR_MESSAGE + " " + "재시도: " + RETRY + ", 종료: " + QUIT + "로만 가능합니다";
}
