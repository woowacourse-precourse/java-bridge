package bridge.domain;

public class GameResult {
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    private String success;
    private int attemptNumber;

    public GameResult() {
        success = SUCCESS_MESSAGE;
        attemptNumber = 0;
    }

    public void addAttemptNumber() {
        attemptNumber += 1;
    }

    public void changeFail() {
        success = FAIL_MESSAGE;
    }

    public String getSuccess() {
        return success;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

}
