package bridge.util;

public enum Commands {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    FINAL_RESULT_MESSAGE("최종 게임 결과\n"),
    REQUEST_BRIDGE_SIZE("다리의 길이를 입력해주세요.\n"),
    REQUEST_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)\n"),
    REQUEST_CONTINUE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"),
    EMPTY_LINE("\n");

    private final String message;

    Commands(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
