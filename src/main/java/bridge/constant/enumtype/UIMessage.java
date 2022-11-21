package bridge.constant.enumtype;

public enum UIMessage {
    INFO_GAME_START("다리 건너기 게임을 시작합니다."),
    REQUEST_INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    REQUEST_INPUT_MOVE_CELL("이동할 칸을 선택해주세요. (위: " + BridgeGameRule.MOVE_UP.getValue() + ", 아래: "
            + BridgeGameRule.MOVE_DOWN.getValue() + ")"),
    REQUEST_INPUT_RETRY_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + BridgeGameRule.RETRY.getValue()
            + ", 종료: "+ BridgeGameRule.QUIT.getValue() +")"),
    INFO_GAME_RESULT("최종 게임 결과"),
    INFO_GAME_IS_SUCCESS("게임 성공 여부: "),
    INFO_GAME_SUCCESS("성공"),
    INFO_GAME_FAILED("실패"),
    INFO_RETRY_COUNT("총 시도한 횟수: "),
    INFO_BRIDGE_OPEN("[ "),
    INFO_BRIDGE_CLOSE(" ]"),
    INFO_BRIDGE_SEPARATED(" | "),
    INFO_BRIDGE_MOVE_SUCCESS("O"),
    INFO_BRIDGE_MOVE_FAILED("X"),
    ERROR_PREFIX("[ERROR] "),
    ERROR_BRIDGE_LENGTH_INCLUSIVE(ERROR_PREFIX.getValue() + " 다리의 길이는 "
            + BridgeLengthInclusive.START.getValue() + "이상 " + BridgeLengthInclusive.END.getValue() + " 이하입니다."),
    ERROR_NUMBER_TYPE(ERROR_PREFIX.getValue() + " 다리의 길이를 숫자로 입력해주세요."),
    ERROR_INPUT_MOVE_CELL("영어 대문자 1자를 입력해주세요. (위: " + BridgeGameRule.MOVE_UP.getValue() + ", 아래: "
            + BridgeGameRule.MOVE_DOWN.getValue() + ")"),
    ERROR_INPUT_RETRY_GAME("영어 대문자 1자를 입력해주세요. (재시도: " + BridgeGameRule.RETRY.getValue()
            + ", 종료: "+ BridgeGameRule.QUIT.getValue() +")")
    ;

    private String value;
    UIMessage(String value) {
        this.value = value;
    }

    public String getkey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
