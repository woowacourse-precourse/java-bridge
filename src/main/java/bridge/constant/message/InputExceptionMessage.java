package bridge.constant.message;

public class InputExceptionMessage {

    public static final String WRONG_BRIDGE_SIZE = "[ERROR] 다리 길이는 3과 20 사이의 숫자여야 합니다.";
    public static final String WRONG_MOVING = "[ERROR] 다리 이동은 'U(위)' 또는 'D(아래)'여야 합니다.";
    public static final String WRONG_GAME_COMMAND = "[ERROR] 재시도 관련 명령어는 'R(재시작)' 또는 'Q(종료)'여야 합니다.";

    private InputExceptionMessage() {}
}
