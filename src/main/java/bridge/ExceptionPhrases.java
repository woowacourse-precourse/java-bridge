package bridge;

public enum ExceptionPhrases {
    NOT_NUMBER("입력이 숫자가 될 수 없습니다."),
    OUT_OF_RANGE("숫자 입력이 범위를 넘었습니다.");
    private static final String ERROR = "[ERROR]";
    private final String phrases;

    ExceptionPhrases(String phrases) {
        StringBuilder sb = new StringBuilder(ERROR);
        this.phrases = sb.append(" ").append(phrases).toString();
    }

    @Override
    public String toString() {
        return phrases;
    }
}
