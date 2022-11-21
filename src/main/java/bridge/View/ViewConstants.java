package bridge.View;

public enum ViewConstants {

    GAME_START("다리 건너기 게임을 시작합니다."),
    ASK_SIZE("다리의 길이를 입력해주세요."),
    ASK_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: "),
    TRY_NUM("총 시도한 횟수: ");

    private final String message;

    ViewConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
