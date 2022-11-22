package bridge;

public enum ErrorPhrases {
    NOT_NUMBER_STRING("입력이 숫자가 아닙니다."),
    NUMBER_STRING_OUT_OF_RANGE("숫자 입력이 범위를 넘었습니다."),
    NOT_MOVING_STRING("정의되지 않은 입력입니다."),
    NOT_COMMAND_STRING("정의되지 않은 명령입니다.");
    private static final String ERROR = "[ERROR]";
    private final String phrases;

    ErrorPhrases(String phrases) {
        StringBuilder sb = new StringBuilder(ERROR);
        this.phrases = sb.append(" ").append(phrases).toString();
    }

    @Override
    public String toString() {
        return phrases;
    }
}
