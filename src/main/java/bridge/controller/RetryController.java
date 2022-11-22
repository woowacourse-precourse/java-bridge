package bridge.controller;

import java.util.List;

public class RetryController extends Controller {
    public RetryController() {
        super();
    }

    public boolean askToRetryAndQuitAfterReturnIsRetry(boolean isPass) {
        if (isPass) {
            return false;
        }

        return this.inputView.readGameCommand();
    }

    public void printGameMapAndStatus(boolean isPass) {
        int step = this.getLastTreadStep();
        int tries = this.getRetries();
        List<List<String>> maps = this.getSlapMaps(step);

        this.outputView.printResult(maps, isPass, tries);
    }
}
