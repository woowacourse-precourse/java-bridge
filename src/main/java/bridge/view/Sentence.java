package bridge.view;

public enum Sentence {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    YOU_PURCHASED("\n%d개를 구매했습니다."),
    SUCCESS("성공"),
    FAILURE("실패"),

    UP_AND_DOWN("UD"),
    RETRY_AND_QUIT("QR"),

    UP_CHUNK("U"),
    DOWN_CHUNK("D"),
    RETRY_CHUNK("R"),
    QUIT_CHUNK("Q"),

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
