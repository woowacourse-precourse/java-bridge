package bridge.service;

import bridge.controller.BridgeGame;
import bridge.service.constant.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameService {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public BridgeGameService() {
        outputView.printStartMessage();
    }

    public void startBridgeMakingProcess() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.prepare();
        bridgeGame.constructBridge(bridgeSize);
    }

    public void bridgeCrossProcess() {
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        String report = bridgeGame.makeReport();
        outputView.printMap(report);

    }

    public boolean playGame() {

        while (bridgeGame.isGameEnd()) {
            bridgeCrossProcess();
            if (bridgeGame.isFailedGame()) {
                break;
            }
        }
        bridgeGame.updateTotalCount();
        return bridgeGame.isFailedGame();
    }

}
