package bridge;

public enum BridgeGameMessage {

    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_OF_END("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    SUCCESS_OR_FAILURE("게임 성공 여부: %s"),
    SUCCESS("성공"),
    FAILURE("실패"),
    TRY_COUNT("총 시도한 횟수: %d");


    private final String value;

    BridgeGameMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String returnSuccessOrFailure(boolean trueOrFalse) {
        if (!trueOrFalse) {
            return FAILURE.getValue();
        }
        return SUCCESS.getValue();
    }
}
