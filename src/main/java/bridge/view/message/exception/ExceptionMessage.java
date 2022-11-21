package bridge.view.message.exception;

public interface ExceptionMessage {
    String ERROR_WRONG_LENGTH = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    String ERROR_WRONG_MOVING = "[ERROR] 다리는 U 또는 D로만 이동할 수 있습니다.";
    String ERROR_WRONG_COMMAND = "[ERROR] 재시도는 R, 종료는 Q를 입력해 주세요.";
}
