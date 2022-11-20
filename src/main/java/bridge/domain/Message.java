package bridge.domain;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    // INPUT MESSAGES -------------------------------------------------------------
    INPUT_BRIDGE_SIZE("\n다리의 길이를 입력해주세요.\n"),
    INPUT_DIRECTION("\n이동할 칸을 선택해주세요.\n"),
    INPUT_RETRY_GAME("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"),
    // ERROR MESSAGES -------------------------------------------------------------
    ERROR_SIZE_NOT_INTEGER("\n[ERROR] 다리 길이는 정수형 숫자여야 합니다.\n"),
    ERROR_SIZE_OUT_OF_RANGE("\n[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n"),
    ERROR_DIRECTION_OUT_OF_RANGE("\n[ERROR] 이동할 방향은 U 혹은 D인 문자여야 합니다.\n"),
    ERROR_COMMAND_OUT_OF_RANGE("\n[ERROR] 명령어는 R 혹은 Q인 물자여야 합니다.\n");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}