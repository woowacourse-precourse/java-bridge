package bridge.view.constant;

public enum GameMessage {
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_NEXT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_HEADER("최종 게임 결과"),
    GAME_RESULT_BODY("게임 성공 여부: "),
    GAME_RESULT_ATTEMPTS("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
