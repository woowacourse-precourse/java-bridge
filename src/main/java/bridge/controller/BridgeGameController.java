package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.MessageStorage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    public void start() {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.bridgeMaking(bridgeSize);
        gameContinue(bridgeSize, bridgeGame);
        OutputView.printResult(bridgeGame.returnResult(), bridgeGame.isSuccess(bridgeSize), bridgeGame.totalTryTime());
    }

    private void retry(int bridgeSize, BridgeGame bridgeGame) {
        String gameCommand = InputView.readGameCommand();
        if (gameCommand.equals(MessageStorage.RESTART.getMessage())) {
            bridgeGame.retry();
            gameContinue(bridgeSize, bridgeGame);
        }
    }

    private void gameContinue(int bridgeSize, BridgeGame bridgeGame) {
        for (int i = 0; i < bridgeSize; i++) {
            List<List<String>> bridgeCorrects = bridgeGame.move(InputView.readMoving(), i);
            OutputView.printMap(bridgeCorrects);
            if (!bridgeGame.wrongSelect(i)) {
                retry(bridgeSize, bridgeGame);
                return;
            }
        }
    }
}
