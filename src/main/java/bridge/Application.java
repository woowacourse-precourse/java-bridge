package bridge;

import static bridge.utils.message.GameMessagesUtil.CHOICE_MOVE;
import static bridge.utils.message.GameMessagesUtil.INPUT_BRIDGE_SIZE;
import static bridge.utils.message.GameMessagesUtil.INPUT_RETRY;
import static bridge.utils.message.GameMessagesUtil.START;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.utils.console.InputView;
import bridge.utils.console.OutputView;
import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void main(String[] args) {
        List<String> bridge = getBridge();

        BridgeGame game = play(bridge);

        result(game);
    }

    private static List<String> getBridge() {
        output.printMessage(START.getMessage());
        List<String> bridge = makeBridge();
        output.printMessage();

        return bridge;
    }

    private static List<String> makeBridge() {
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
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

    private static BridgeGame play(List<String> bridge) {
        BridgeGame game = new BridgeGame(bridge);
        while (!game.isFinish()) {
            String choiceMove = getChoiceMove();
            showMoveResult(game.move(choiceMove));

            if (game.isFail()) {
                game.retry(getChoiceRetry());
            }
        }
        return game;
    }

    private static String getChoiceMove() {
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

    private static String getChoiceRetry() {
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
