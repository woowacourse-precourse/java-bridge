package bridge.router;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameRouter {

    private static final String RESTART = "R";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameRouter(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void process() {
        routeInitiation();
        routeGaming();
    }

    private void routeInitiation() {
        outputView.printStartMessage();
        outputView.printBlankLine();
        routeSettingBridgeSize();
    }

    private void routeSettingBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printBlankLine();
        bridgeGame.setBridge(bridgeSize);
    }

    private void routeGaming() {
        routeEachTurn();
        while (inputView.readGameCommand().equals(RESTART)) {
            routeEachTurn();
        }
    }

    private void routeEachTurn() {

    }
}
