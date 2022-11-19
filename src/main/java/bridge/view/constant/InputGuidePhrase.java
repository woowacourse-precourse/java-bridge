package bridge.view.constant;

public enum InputGuidePhrase {
    BRIDGE_LENGTH("다리의 길이를 입력해주세요.");

    private final String phrase;

    private InputGuidePhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
