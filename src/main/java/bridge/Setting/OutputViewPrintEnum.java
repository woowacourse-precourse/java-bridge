package bridge.Setting;

public enum OutputViewPrintEnum {
    GAME_START("다리 건너기 게임을 시작합니다."),
    FINAL_RESULT("최종 게임 결과"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (%s)"),
    INPUT_BRIDGE_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (%s)"),
    OUTPUT_BRIDGE_SIDE("[ %s ]"),
    OUTPUT_BRIDGE_SIDE_SEPARATOR(" | "),
    OUTPUT_CHECK_SUCCESS("게임 성공 여부: %s"),
    OUTPUT_RESULT_SUCCESS("성공"),
    OUTPUT_RESULT_FAIL("실패"),
    OUTPUT_TRY_TIME("총 시도한 횟수: %d"),
    CHANGE_STRING("%s"),
    CHANGE_INT("%d");

    private final String message;

    OutputViewPrintEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
