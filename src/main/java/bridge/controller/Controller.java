package bridge.controller;

import static bridge.constant.GameCommand.RETRY;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.Direction;
import bridge.constant.GameCommand;
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
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
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
        if (tryToMove().wasSuccessful()) {
            return doGame();
        }
        return retryOrExit();
    }

    private int retryOrExit() {
        if (askForRetry().equals(RETRY)) {
            game.retry();
            trialResults.clear();
            return doGame() + RETRY_ADD_COUNT;
        }
        return INITIAL_TRIAL_COUNT;
    }

    private TrialResult tryToMove() {
        try {
            return move(inputView.readDirection());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return tryToMove();
        }
    }

    private TrialResult move(Direction direction) {
        TrialResult trialResult = new TrialResult(direction, game.move(direction));
        trialResults.add(trialResult);
        outputView.printMap(trialResults);
        return trialResult;
    }

    private GameCommand askForRetry() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return askForRetry();
        }
    }
}
