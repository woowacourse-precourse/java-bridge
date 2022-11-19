package bridge;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("\n다리의 길이를 입력해주세요.\n"),
    ERROR_SIZE_NOT_INTEGER("\n[ERROR] 다리 길이는 정수형 숫자여야 합니다.\n"),
    ERROR_SIZE_OUT_OF_RANGE("\n[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}