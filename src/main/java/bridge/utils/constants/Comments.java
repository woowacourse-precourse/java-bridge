package bridge.utils.constants;

public enum Comments {

    GAME_START("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_PLACE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS_OR_NOT("게임 성공 여부: "),
    NUMBER_OF_ATTEMPTS("총 시도한 횟수: "),
    AVAILABLE("O"),
    UNAVAILABLE("X"),
    BLANK(" "),
    SEPARATOR("|"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    SUCCESS("성공"),
    FAIL("실패"),
    UP("U"),
    DOWN("D"),
    GAME_RESTART("R"),
    GAME_QUIT("Q");

    private final String comment;

    Comments(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
