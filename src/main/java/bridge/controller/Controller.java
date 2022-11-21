package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeGame;
import bridge.domain.maker.BridgeMaker;
import bridge.domain.maker.BridgeRandomNumberGenerator;
import bridge.dto.TrialResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private static final int INITIAL_TRIAL_COUNT = 1;
    private static final int RETRY_ADD_COUNT = 1;

    private final InputView inputView;
    private final OutputView outputView;
    private final List<TrialResult> trialResults = new ArrayList<>();
    private BridgeGame game;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        this.game = makeGame();
        int trialCount = doGame();
        outputView.printResult(trialResults, trialCount, game.isFinished());
    }

    private BridgeGame makeGame() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            return BridgeGame.from(bridge);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return makeGame();
        }
    }

    private int doGame() {
        if (game.isFinished()) {
            return INITIAL_TRIAL_COUNT;
        }
        if (!move().wasSuccessful()) {
            return retryOrExit();
        }
        return doGame();
    }

    private int retryOrExit() {
        if (askForRetry()) {
            game.retry();
            trialResults.clear();
            return doGame() + RETRY_ADD_COUNT;
        }
        return INITIAL_TRIAL_COUNT;
    }

    private TrialResult move() {
        try {
            TrialResult trialResult = game.move(inputView.readDirection());
            trialResults.add(trialResult);
            outputView.printMap(trialResults);
            return trialResult;
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return move();
        }
    }

    private boolean askForRetry() {
        try {
            String command = inputView.readGameCommand();
            return command.equals("R");
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return askForRetry();
        }
    }
}
