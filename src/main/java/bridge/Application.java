package bridge;

import static bridge.utils.GameCommand.*;
import static bridge.utils.message.GameMessagesUtil.CHOICE_MOVE;
import static bridge.utils.message.GameMessagesUtil.INPUT_BRIDGE_SIZE;
import static bridge.utils.message.GameMessagesUtil.INPUT_RETRY;
import static bridge.utils.message.GameMessagesUtil.START;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.utils.GameCommand;
import bridge.utils.Move;
import bridge.utils.console.InputView;
import bridge.utils.console.OutputView;
import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame(getBridge());

        play(game);

        result(game);
    }

    private static List<String> getBridge() {
        output.printMessage(START.getMessage());
        List<String> bridge = makeBridge();
        output.printMessage();

        return bridge;
    }

    private static List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(readBridgeSize());
    }

    private static int readBridgeSize() {
        while (true) {
            try {
                output.printMessage(INPUT_BRIDGE_SIZE.getMessage());
                return input.readBridgeSize();
            } catch (IllegalArgumentException ex) {
                output.printMessage(ex.getMessage());
            }
        }
    }

    private static void play(BridgeGame game) {
        GameCommand command = PLAY;
        while (command.isPlay()) {
            Move movable = tryMove(game);
            command = game.isFinish();
            if (movable.isFail()) {
                command = getRetryCommand(game);
            }
        }
    }

    private static Move tryMove(BridgeGame game) {
        Move movable = game.move(getChoiceMove());
        showMoveResult(game.getMoveResult());
        return movable;
    }

    private static Move getChoiceMove() {
        while (true) {
            try {
                output.printMessage(CHOICE_MOVE.getMessage());
                return input.readMoving();
            } catch (IllegalArgumentException ex) {
                output.printMessage(ex.getMessage());
            }
        }
    }

    private static void showMoveResult(MoveResult moveResult) {
        output.printMap(moveResult);
    }

    private static GameCommand getRetryCommand(BridgeGame game) {
        GameCommand command;
        command = getChoiceRetry();
        game.retry(command);
        return command;
    }

    private static GameCommand getChoiceRetry() {
        while (true) {
            try {
                output.printMessage(INPUT_RETRY.getMessage());
                return input.readGameCommand();
            } catch (IllegalArgumentException ex) {
                output.printMessage(ex.getMessage());
            }
        }
    }

    private static void result(BridgeGame game) {
        output.printResult(game);
    }
}
