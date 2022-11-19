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

        gameProcess(new BridgeGame(bridge));
    }

    private void gameProcess(BridgeGame bridgeGame) {
        do {
            BridgeMap bridgeMap = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeMap.getMap());
        } while (checkWinning(bridgeGame) && (checkGameStatus(bridgeGame) || checkRestart(bridgeGame)));
        outputView.printResult(bridgeGame.getResult());
    }

    private boolean checkWinning(BridgeGame bridgeGame) {
        return !bridgeGame.isWinningBrideGame();
    }

    private boolean checkGameStatus(BridgeGame bridgeGame) {
        return bridgeGame.checkStatus();
    }

    private boolean checkRestart(BridgeGame bridgeGame) {
        return bridgeGame.retry(inputView.readGameCommand());
    }
}
