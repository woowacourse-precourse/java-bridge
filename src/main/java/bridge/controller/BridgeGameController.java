package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.InputValidator;
import bridge.model.constant.MoveDirection;
import bridge.model.constant.RetryIntention;
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

            if (bridgeGame.succeed() || !RetryIntention.wantRetry(getRetryIntention())) {
                return;
            }

            bridgeGame.retry();
        }
    }

    public void processOneGame() {
        do {
            bridgeGame.move(getMoveDirection());
            outputView.printMap(bridgeGame.getSimpleGameResult());
        } while (bridgeGame.inProcess());
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

    private MoveDirection getMoveDirection() {
        try {
            String directionString = inputView.readMoving();
            validator.validateMoveChoice(directionString);
            return MoveDirection.getMatchDirection(directionString);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMoveDirection();
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