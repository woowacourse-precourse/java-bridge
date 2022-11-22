package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    
    private int trialCnt;

    public void play() {
        trialCnt = 1;
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        playUntilGameOver(bridge);

        outputView.printTrialCnt(trialCnt);
    }

    private void playUntilGameOver(List<String> bridge) {
        while(true) {
            String movingCommand = inputView.readMoving();
            List<String> bridgeStatus = bridgeGame.move(movingCommand, bridge);
            outputView.printMap(bridge, bridgeStatus);

            if (gameSuccess(bridge)) break;
            if (gameFailure()) break;
        }
    }

    private boolean gameSuccess(List<String> bridge) {
        if (bridgeGame.isSuccess(bridge)) {
            outputView.printResult();
            outputView.printSuccess();
            return true;
        }

        return false;
    }

    private boolean gameFailure() {
        if (bridgeGame.isFailure()) {
            String gameCommand = inputView.readGameCommand();

            if (quit(gameCommand)) return true;
            retry(gameCommand);
        }

        return false;
    }

    private boolean quit(String gameCommand) {
        if (gameCommand.equals("Q")) {
            outputView.printResult();
            outputView.printFailure();
            return true;
        }

        return false;
    }

    private void retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            trialCnt++;
        }
    }
}