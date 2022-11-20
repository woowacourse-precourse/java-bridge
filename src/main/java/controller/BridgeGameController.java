package controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import model.Bridge;
import model.BridgeGame;
import model.InputValidator;
import model.enums.GameStatus;
import model.enums.RetryIntention;
import view.InputView;
import view.OutputView;

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
        bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(getBridgeSize())));
    }

    public void process() {
        GameStatus status;
        while (true) {
            processOneGame();
            status = bridgeGame.getGameStatus();

            if (status.succeed()) {
                return;
            }

            if (RetryIntention.wantRetry(getRetryIntention())) {
                bridgeGame.retry();
            }
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