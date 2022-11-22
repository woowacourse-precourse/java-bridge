package bridge.domain;

import java.util.Arrays;

public enum Answer {
    RIGHT("O", true),
    WRONG("X", false);

    private String message;
    private boolean isCorrect;

    Answer(String message, boolean isCorrect) {
        this.message = message;
        this.isCorrect = isCorrect;
    }

    public static Answer of(boolean isCorrect) {
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.isCorrect == isCorrect)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getMessage() {
        return message;
    }
}
