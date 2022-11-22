package bridge.controller;

import static bridge.constant.GameCommand.RETRY;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.GameCommand;
import bridge.domain.BridgeGame;
import bridge.domain.maker.BridgeMaker;
import bridge.domain.maker.BridgeRandomNumberGenerator;
import bridge.dto.TrialResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private static final int INITIAL_TRIAL_COUNT = 1;
    private static final int RETRY_ADD_COUNT = 1;

    private BridgeGame game;

    public void run() {
        game = makeGame();
        int trialCount = doGame();
        OUTPUT_VIEW.printResult(game.getTrialResults(), trialCount, game.isFinished());
    }

    private BridgeGame makeGame() {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(INPUT_VIEW.readBridgeSize());
            return BridgeGame.from(bridge);
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printException(exception.getMessage());
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
        if (askCommand().equals(RETRY)) {
            game.retry();
            return doGame() + RETRY_ADD_COUNT;
        }
        return INITIAL_TRIAL_COUNT;
    }

    private TrialResult tryToMove() {
        try {
            TrialResult trialResult = game.move(INPUT_VIEW.readDirection());
            OUTPUT_VIEW.printMap(game.getTrialResults());
            return trialResult;
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printException(exception.getMessage());
            return tryToMove();
        }
    }

    private GameCommand askCommand() {
        try {
            return INPUT_VIEW.readGameCommand();
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printException(exception.getMessage());
            return askCommand();
        }
    }
}
