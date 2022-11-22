package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static final int INITIAL_TRIAL_CNT = 1;
    private static final String QUIT_COMMAND = "Q";
    private static final String RETRY_COMMAND = "R";

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    
    private int trialCnt;

    public void play() {
        trialCnt = INITIAL_TRIAL_CNT;
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
        if (gameCommand.equals(QUIT_COMMAND)) {
            outputView.printResult();
            outputView.printFailure();
            return true;
        }

        return false;
    }

    private void retry(String gameCommand) {
        if (gameCommand.equals(RETRY_COMMAND)) {
            bridgeGame.retry();
            trialCnt++;
        }
    }
}