package bridge.view;

public enum GameMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    SHOW_RESULT("게임 성공 여부: %s%n"),
    SHOW_TRIES("총 시도한 횟수: %d%n");

    private final String message;
    GameMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
