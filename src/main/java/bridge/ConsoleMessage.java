package bridge;

public enum ConsoleMessage {
    GAME_START("다리 건너기 게임을 시작합니다.\n"),
    REQUEST_INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    REQUEST_INPUT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REQUEST_INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_CLEAR("게임 성공 여부: 성공"),
    GAME_OVER("게임 성공 여부: 실패"),
    TRY_COUNT("총 시도한 횟수: %d");


    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
