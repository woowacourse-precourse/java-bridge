package bridge;

import bridge.domain.Retry;
import bridge.service.RetryService;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RetryController {

    public static final String GAME_SUCCESS = "성공";

    private final RetryService retryService;
    private final List<String>[] bridgeMove;
    private final int count;

    public RetryController(RetryService retryService, List<String>[] bridgeMove, int count) {
        this.retryService = retryService;
        this.bridgeMove = bridgeMove;
        this.count = count;
    }

    public boolean run() {
        if (retryService.checkSuccessful(bridgeMove)) {
            printResult(GAME_SUCCESS);
            return false;
        }
        if (retryService.checkRetry(readRetry())) {
            return true;
        }
        return false;
    }

    private Retry readRetry() {
        Retry retry = new Retry(new InputView().readGameCommand());
        return retry;
    }

    private void printResult(String successful) {
        new OutputView().printResult(bridgeMove, successful, count);
    }
}
