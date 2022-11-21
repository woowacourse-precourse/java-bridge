package bridge.Message;

public enum GuideMessage {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    REQUEST_BRIDGE_SIZE_MESSAGE("\n다리의 길이를 입력해주세요."),
    REQUEST_MOVE_COMMAND_MESSAGE("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REQUEST_RETRY_COMMAND_MESSAGE("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_MESSAGE("\n최종 게임 결과"),
    GAME_SUCCESS_OR_NOT_MESSAGE("\n게임 성공 여부: "),
    GAME_SUCCESS_MESSAGE("성공"),
    GAME_FAIL_MESSAGE("실패"),
    TOTAL_GAME_COUNT_MESSAGE("총 시도한 횟수: ");
    private String guideMessage;

    GuideMessage(String guideMessage) {
        this.guideMessage = guideMessage;
    }

    public String getGuideMessage() {
        return guideMessage;
    }
}
