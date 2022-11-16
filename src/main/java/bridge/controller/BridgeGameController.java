package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();

    private final InputView inputView = new InputView();

    private final ExceptionHandle exceptionHandle = new ExceptionHandle(outputView);

    public void startGame() {
        outputView.printGameStart();
        int bridgeSize = getBridgeSize();
    }

    private int getBridgeSize() {
        return exceptionHandle.getCorrectInput(() -> {
            outputView.printRequestBridgeLength();
            return inputView.readBridgeSize();
        });
    }

}
