package utils;

public enum Message {
    SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE("[ERROR] 입력은 U와 D 중 하나 여야합니다. (위: U, 아래: D)"),
    RETRY("[ERROR] 입력은 R과 Q 중 하나 여야합니다. (재시도: R, 종료: Q)"),
    NUMBER("[ERROR] 숫자만 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}