package bridge.message;

public class Error {
    public static final String ERROR = "[ERROR] ";
    public static final String WRONG_BRIDGE_NUMBER = ERROR + "다리 길이는 3이상 20이하인 숫자만 가능합니다.";
    public static final String WRONG_DIRECTION_INPUT = ERROR + "이동할 칸은 U 또는 D만 가능합니다.";
    public static final String WRONG_RETRY_INPUT = ERROR + "재시도 입력은 R 또는 Q만 가능합니다.";

}
