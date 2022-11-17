package bridge;

public class MessageToResult {

    private String message;
    private boolean correct;

    public MessageToResult(String message, boolean correct) {
        this.message = message;
        this.correct = correct;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCorrect() {
        return correct;
    }
}
