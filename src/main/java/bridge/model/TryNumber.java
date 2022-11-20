package bridge.model;

import bridge.view.OutputView;

public class TryNumber {
    private Integer tryNumber = 1;

    public void addAttemptNumber() {
        tryNumber += 1;
    }

    public void printAttemptNumber(OutputView outputView, boolean success) {
        outputView.printResult(tryNumber, success);
    }
}
