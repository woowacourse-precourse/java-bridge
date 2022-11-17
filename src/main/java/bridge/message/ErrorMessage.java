package bridge.message;

public final class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String BRIDGE_SIZE_ERROR = ERROR + "다리의 크기는 3 ~ 20 사이의 크기로 생성해야 합니다.";
    public static final String INPUT_MOVE_ERROR = ERROR + "위로 가려면 U, 밑으로 가려면 D를 입력해주세요.";
    public static final String INPUT_RETRY_ERROR = ERROR + "재시도는 R, 게임 종료는 Q를 입력해주세요.";
}
