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
            bridgeGame.getMap();
            outputView.printMap(bridgeGame.getMap());
        } while (!isWinningGame(bridgeGame) && (checkGameStatus(bridgeGame) || checkRestart(bridgeGame)));
        outputView.printResult(bridgeGame.getResult());
    }

    private boolean checkGameStatus(BridgeGame bridgeGame) {
        return bridgeGame.checkStatus();
    }

    private boolean isWinningGame(BridgeGame bridgeGame) {
        return bridgeGame.checkWinning();
    }

    private boolean checkRestart(BridgeGame bridgeGame) {
        return bridgeGame.retry(inputView.readGameCommand());
    }
}
