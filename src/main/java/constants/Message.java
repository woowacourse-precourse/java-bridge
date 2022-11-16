package constants;

public abstract class Message {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";

    public static final String INPUT_PATTERN_ERROR_MESSAGE = "[ERROR] 입력은 0이상의 숫자로만 이루어져야 합니다.";
    public static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 3이상 20이하여야 합니다.";

    private Message() {}
}
