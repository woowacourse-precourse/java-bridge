package bridge;

import java.util.List;
import java.util.stream.Collectors;

public class RetryProcessing {

    private final InputView inputView;
    private final OutputView outputView;

    public RetryProcessing() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    //리트라이를 할 때 R을 눌렀는지 아닌지 확인
    private boolean inputRetryCommand(String inputCommand) {
        boolean doRetry = inputCommand.equals("R");

        return doRetry;
    }
}
