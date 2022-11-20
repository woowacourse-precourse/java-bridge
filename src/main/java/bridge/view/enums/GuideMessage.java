package bridge.view.enums;

public enum GuideMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_INPUT_MESSAGE("다리의 길이를 입력해주세요.\n"),
    MOVING_INPUT_MESSAGE("\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}