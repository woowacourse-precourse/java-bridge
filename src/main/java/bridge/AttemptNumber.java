package bridge;

public class AttemptNumber {
    private Integer attemptNumber = 0;

    public void addAttemptNumber() {
        attemptNumber += 1;
    }

    public void printAttemptNumber(OutputView outputView, boolean success) {
        outputView.printResult(attemptNumber, success);
    }

}
