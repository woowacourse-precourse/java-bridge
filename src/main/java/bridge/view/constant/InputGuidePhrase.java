package bridge.view.constant;

public enum InputGuidePhrase {
    BRIDGE_LENGTH("다리 건너기 게임을 시작합니다.");

    private final String phrase;

    private InputGuidePhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
