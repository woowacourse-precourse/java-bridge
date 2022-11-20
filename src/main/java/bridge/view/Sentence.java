package bridge.view;

public enum Sentence {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    YOU_PURCHASED("\n%d개를 구매했습니다."),

    LENGTH_NOT_IN_RANGE("[ERROR] Input is not in range");

    private final String s;

    Sentence(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
