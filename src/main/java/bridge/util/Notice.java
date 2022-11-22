package bridge.util;

public enum Notice {
    GAME_START("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    USER_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: %s"),
    TOTAL_ATTEMPTS("총 시도한 횟수: %d");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String of() {
        return message;
    }

    public String of(int attempt) {
        return String.format(message, attempt);
    }

    public String of(boolean result) {
        return String.format(message, FinalResult.of(result));
    }
}
