package bridge.constant;

public enum Directive {

    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE_OF_BRIDGE("\n다리의 길이를 입력해주세요."),
    INPUT_MOVE_COMMAND("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("\n최종 게임 결과"),
    WIN_OR_NOT("\n게임 성공 여부: "),
    GAME_COUNT("총 시도한 횟수: ");

    private final String message;

    Directive(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
