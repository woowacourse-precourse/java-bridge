package bridge.common.message;

public class ExceptionMessage {

    /*
     * Exception Error Starting Message
     * */
    public static final String ERROR_CODE = "[ERROR] ";

    /*
     * Exception String Console Out
     * */
    public static final String BRIDGE_LENGTH_OUT_OF_SIZE_MESSAGE = "다리의 길이는 3 이상 20 이하여야 합니다.";

    public static final String BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE = "다리 길이 입력엔 숫자만 가능합니다.";

    public static final String READ_MOVING_INCORRECT_MESSAGE = "U or D 문자만 이동할 수 있습니다.";

    public static final String GAME_COMMAND_INCORRECT_MESSAGE = "R or Q 문자만 게임을 종료 혹은 실행시킬 수 있습니다.";

}
