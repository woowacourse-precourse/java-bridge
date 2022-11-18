package bridge.type;

public enum GuideMessage {

    BRIDGE_GAME_START("다리 건너기 게임을 시작합니다."),

    INPUT_BRIDGE_LENGTH("다리 길이를 입력해주세요."),

    INPUT_MOVE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    GAME_RESULT("최종 게임 결과"),

    GAME_SUCCESS("게임 성공 여부: 성공"),

    GAME_FAIL("게임 성공 여부: 실패"),

    TRY_COUNT("총 시도한 횟수: ");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
