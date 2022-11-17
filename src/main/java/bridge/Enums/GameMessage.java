package bridge.Enums;

public enum GameMessage {
    GAME_START("다리 건너기 게임을 시작합니다.\n"),
    GET_USER_INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    GET_USER_MOVE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GET_USER_RETRY_CHOICE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_END("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    COUNT_OF_RETRY("총 시도한 횟수: ");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
