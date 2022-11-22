package bridge.model.value;

import static bridge.model.value.BridgeRange.MAX;
import static bridge.model.value.BridgeRange.MIN;

public class ErrorMessage {
    public static String PREFIX = "[ERROR] ";
    public static String POSTFIX = " 다시 입력해주세요.";
    public static String BRIDGE_ERROR = "맵이 정상적으로 생성되지 않았습니다.";
    public static String BRIDGEMAP_ERROR = "맵에 생성될 인자가 유효하지 않습니다:";
    public static String NOT_INTEGER_ERROR = "입력값이 정수가 아닙니다.";
    public static String OUTRANGE_ERROR = String.format("입력값이 범위에서 벗어났습니다 %d ~ %d", MIN, MAX);
    public static String MOVE_ERROR = "이동하기 위한 문자가 아닙니다.";
    public static String RETRY_ERROR = "재시작 입력값이 조건에 맞지 않습니다 R(재시작), Q(종료)";
    public static String NOT_ANSWER_ERROR = "입력값이 정수가 아닙니다.";
    public static String NOT_BIT_ERROR  = "0, 1 이외의 값이 들어왔습니다";

    public static String getMessage(String message) {
        return PREFIX + message + POSTFIX;
    }
}
