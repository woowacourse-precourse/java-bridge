package bridge.UI.Output;

public enum OutputString {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    PLAYER_CHOICE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: "),
    TOTAL_PLAYED_NUM("총 시도한 횟수: ");


    private final String message;

    OutputString (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
