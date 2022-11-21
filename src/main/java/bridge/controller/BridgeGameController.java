package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.InputValidator;
import bridge.model.enums.RetryIntention;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputValidator validator = new InputValidator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public void run() {
        process();
        end();
    }

    public void init(BridgeNumberGenerator bridgeNumberGenerator) {
        outputView.printInitComment();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()));
    }

    public void process() {
        while (true) {
            processOneGame();

            if (bridgeGame.getGameStatus().succeed() || !RetryIntention.wantRetry(getRetryIntention())) {
                return;
            }

            bridgeGame.retry();
        }
    }

    public void processOneGame() {
        do {
            bridgeGame.move(getMoving());
            outputView.printMap(bridgeGame.getSimpleGameResult());
        } while (bridgeGame.getGameStatus().in_process());
    }


    public void end() {
        outputView.printResult(bridgeGame.getGameResult());
    }

    private int getBridgeSize() {
        try {
            int size = inputView.readBridgeSize();
            validator.validateBridgeLength(size);
            return size;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getBridgeSize();
        }
    }

    private String getMoving() {
        try {
            String moving = inputView.readMoving();
            validator.validateMoveChoice(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMoving();
        }
    }

    private String getRetryIntention() {
        try {
            String intention = inputView.readGameCommand();
            validator.validateRetryIntention(intention);
            return intention;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getRetryIntention();
        }
    }
}