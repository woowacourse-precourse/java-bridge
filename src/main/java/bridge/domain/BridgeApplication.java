package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

public class BridgeApplication {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStartMessage();

        Bridge bridge = new Bridge(inputView.readBridgeSize());

        gameProcess(new BridgeGame(bridge.getBridge()));
    }

    private void gameProcess(BridgeGame bridgeGame) {
        do {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeMap(), bridgeGame.getMapCoordinate());
        } while (bridgeGame.isContinueStatus() || checkRestart(bridgeGame));
        outputView.printResult(bridgeGame.getResult());
    }

    private boolean checkRestart(BridgeGame bridgeGame) {
        if (bridgeGame.isRetryable() && inputView.readGameCommand().equals(GameCommand.RESTART)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
