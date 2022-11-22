package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.controller.cosntant.GameCommand;
import bridge.domain.model.BridgeGame;
import bridge.domain.model.Player;
import bridge.view.OutputView;

public class BridgeGameController {
    InputController inputController = new InputController();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;
    Player player = new Player();

    public BridgeGameController(BridgeNumberGenerator bridgeNumberGenerator){
        this.bridgeGame = new BridgeGame(bridgeNumberGenerator);
    }


    public void startBridgeMakingProcess() {
        int bridgeSize = inputController.checkBridgeSize();

        bridgeGame.prepare();

        bridgeGame.constructBridge(bridgeSize);
    }

    public void bridgeCrossProcess() {
        String moving = inputController.checkMoving();

        player.saveDirection(moving);

        bridgeGame.move(player.notifyDirection());

        String report = bridgeGame.makeReport(player.getCurrentDirection());

        outputView.printMap(report);
    }

    public boolean isSingleGameEnd() {
        return (bridgeGame.isGameEnd() && bridgeGame.isCrossSuccess());
    }

    public void playSingleGame() {

        bridgeGame.prepare();

        while (isSingleGameEnd()) {
            bridgeCrossProcess();
        }
        bridgeGame.updateTotalCount();
    }

    public void retryProcess() {
        if (!bridgeGame.isCrossSuccess()) {
            bridgeGame.Restart(askRetry());
        }
    }

    public boolean askRetry() {
        String gameCommand = inputController.checkGameCommand();
        return GameCommand.transformToAction(gameCommand);
    }

    public boolean isGameContinue() {
        if (bridgeGame.getRestartState()) {
            return true;
        }
        return bridgeGame.isCrossSuccess() && bridgeGame.getRestartState();
    }

    public void endProcess() {
        String report = bridgeGame.getFinalResult();
        outputView.printMapResult(report);
        outputView.printGameResult(bridgeGame.getBridgeGameState());
        outputView.printTotalTrial(bridgeGame.getTotalTrial());
    }

    public void start() {
        outputView.printStartMessage();
        startBridgeMakingProcess();
        do {
            playSingleGame();
            retryProcess();
        } while (isGameContinue());
        endProcess();
    }
}
