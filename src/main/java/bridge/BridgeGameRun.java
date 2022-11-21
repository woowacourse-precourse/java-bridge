package bridge;

import java.util.List;

public class BridgeGameRun {

    private final InputView inputView;
    private final InputValidation inputValidation;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private boolean result;

    public BridgeGameRun(InputView inputView, InputValidation inputValidation, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidation = inputValidation;
        this.outputView = outputView;
    }
}
