package bridge;

public class ErrorMessage {
    public static final String BASE_ERROR_MESSAGE = "[ERROR] ";
    public static final String BRIDGE_SIZE_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVE_COMMAND_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "위: U, 아래: D를 입력해야 합니다.";
    public static final String RETRY_COMMAND_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "재시도: R, 종료: Q를 입력해야 합니다.";

}
