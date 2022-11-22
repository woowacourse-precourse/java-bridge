package bridge.view.enums;

public enum GuideMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
    MOVING_INPUT_MESSAGE("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    COMMAND_INPUT_MESSAGE("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_MESSAGE("\n최종 게임 결과"),
    SUCCESS_OR_NOT_MESSAGE("\n게임 성공 여부: %s\n"),
    ATTEMPTS_MESSAGE("총 시도한 횟수: %d\n");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}