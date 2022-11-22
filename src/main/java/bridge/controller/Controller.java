package bridge.controller;

import static bridge.constant.GameCommand.EXIT;
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
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private final List<TrialResult> trialResults = new ArrayList<>();

    public void run() {
        BridgeGame game = makeGame();
        doGame(game);
        OUTPUT_VIEW.printResult(trialResults, game.getTrialCount(), game.isFinished());
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
            if (move(game)) {
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
            trialResults.clear();
        }
        return command;
    }

    private boolean move(final BridgeGame game) {
        Direction direction = askDirection();
        boolean moved = game.move(direction);

        trialResults.add(new TrialResult(direction, moved));
        OUTPUT_VIEW.printMap(trialResults);
        return moved;
    }

    private Direction askDirection() {
        try {
            return INPUT_VIEW.readDirection();
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printException(exception.getMessage());
            return askDirection();
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
