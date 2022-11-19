package bridge.exception;

public enum ExceptionPhrases {
    BridgeSizeRange("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BridgeSizeNumber("[ERROR] 다리 길이는 숫자여야 합니다."),
    MovingValue("[ERROR] D 또는 U만 입력 가능합니다.");

    private String phrase;

    ExceptionPhrases(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
