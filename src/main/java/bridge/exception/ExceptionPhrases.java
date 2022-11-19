package bridge.exception;

public enum ExceptionPhrases {
    BridgeSize("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private String phrase;

    ExceptionPhrases(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
