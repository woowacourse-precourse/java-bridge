package bridge.constants;

public class ErrorMessages {

    public static final String PREFIX = "[ERROR] ";
    public static final String INVALID_BRIDGE_INPUT = "다리 길이는 숫자만 입력 가능합니다.";
    public static final String INVALID_BRIDGE_SIZE = "다리 길이는 3이상 20이하의 값만 입력 가능합니다.";
    public static final String INVALID_MOVE_COMMAND = "이동할 칸은 U와 D만 입력 가능합니다.";
    public static final String INVALID_GAME_COMMAND = "게임 재시작/종료 명령은 R과 Q만 가능합니다.";

    private ErrorMessages() {
    }
}
