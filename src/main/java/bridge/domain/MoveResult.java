package bridge.domain;

public class MoveResult {

    private String message;
    private boolean correct;

    public String getMessage() {
        return message;
    }

    public boolean isCorrect() {
        return correct;
    }

    public MoveResult(String message, boolean correct) {
        this.message = message;
        this.correct = correct;
    }

}
