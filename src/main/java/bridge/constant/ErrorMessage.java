package bridge.constant;

public class ErrorMessage {

    public static final String ERROR = "[ERROR] ";

    public static final String WRONG_BRIDGE_SIZE = ERROR + "다리의 길이는 3이상 20이하의 정수 입니다.";
    public static final String WRONG_BRIDGE_SIZE_TYPE = ERROR + "다리의 길이는 정수값이여야 합니다.";

    public static final String WRONG_MOVING_VALUE = ERROR + "이동할 수 있는 칸은 U 또는 D 입니다.";

    public static final String WRONG_GAME_COMMAND_VALUE = ERROR + "재시작/종료 입력 값은 R 또는 Q 입니다.";
}
