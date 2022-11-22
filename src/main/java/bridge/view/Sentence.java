package bridge.view;

public enum Sentence {

    BEGIN_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_MONEY("구입금액을 입력해 주세요."),
    YOU_PURCHASED("\n%d개를 구매했습니다."),
    SUCCESS("성공"),
    FAILURE("실패"),
    BLANK_LINE(""),
    FINAL_RESULT("최종 게임 결과\n"),
    GAME_SUCCESS_OR_FAIL("게임 성공 여부: "),
    TOTAL_TRIAL("총 시도한 횟수: "),

    UP_AND_DOWN("UD"),
    RETRY_AND_QUIT("QR"),

    UP_CHUNK("U"),
    DOWN_CHUNK("D"),
    RETRY_CHUNK("R"),
    QUIT_CHUNK("Q"),

    THREE_SIZE_O(" O "),
    THREE_SIZE_BLANK("   "),
    THREE_SIZE_X(" X "),

    DELIMITER("|"),
    START_BRIDGE("["),
    END_BRIDGE("]"),

    LENGTH_NOT_IN_RANGE("Input is not in range"),
    INPUT_NOT_U_OR_D("Input is not U or D"),
    INPUT_NOT_R_OR_Q("Input is not Q or R");

    private final String s;

    Sentence(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
