package bridge.Setting;

public enum OutputViewPrintEnum {
    GAME_START("다리 건너기 게임을 시작합니다." + System.lineSeparator()),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요." + System.lineSeparator()),
    INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (%s)" + System.lineSeparator()),
    INPUT_BRIDGE_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (%s)" + System.lineSeparator()),
    OUTPUT_BRIDGE_SIDE("[ %s ]" + System.lineSeparator()),
    OUTPUT_BRIDGE_SIDE_SEPARATOR(" | "),
    OUTPUT_CHECK_SUCCESS("게임 성공 여부: %s" + System.lineSeparator()),
    OUTPUT_TRY_TIME("총 시도한 횟수: %d" + System.lineSeparator()),
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
