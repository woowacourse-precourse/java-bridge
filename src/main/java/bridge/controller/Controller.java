package bridge.controller;

import static bridge.constant.GameCommand.EXIT;
import static bridge.constant.GameCommand.RETRY;

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

    public void run() {
        BridgeGame game = makeGame();
        doGame(game);
        OUTPUT_VIEW.printResult(game.getTrialResults(), game.getTrialCount(), game.isFinished());
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

    private void doGame(final BridgeGame game) {
        while (!game.isFinished()) {
            if (move(game).wasSuccessful()) {
                continue;
            }
            if (retryOrExit(game) == EXIT) {
                break;
            }
        }
    }

    private GameCommand retryOrExit(final BridgeGame game) {
        GameCommand command = askCommand();
        if (command.equals(RETRY)) {
            game.retry();
        }
        return command;
    }

    private TrialResult move(final BridgeGame game) {
        try {
            TrialResult trialResult = game.move(INPUT_VIEW.readDirection());
            OUTPUT_VIEW.printMap(game.getTrialResults());
            return trialResult;
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printException(exception.getMessage());
            return move(game);
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
