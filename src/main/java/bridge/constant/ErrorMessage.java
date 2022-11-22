package bridge.constant;

public enum ErrorMessage {
    IS_NUMBER("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_UP_DOWN("[ERROR] 이동할 칸은 U 또는 D 이어야 합니다."),
    INPUT_QUIT_RESTART("[ERROR] 재시작/종료는 Q 또는 R 이어야 합니다.");

    public final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
}
