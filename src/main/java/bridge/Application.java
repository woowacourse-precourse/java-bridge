package bridge;

import static bridge.utils.message.GameMessagesUtil.CHOICE_MOVE;
import static bridge.utils.message.GameMessagesUtil.INPUT_BRIDGE_SIZE;
import static bridge.utils.message.GameMessagesUtil.START;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.utils.console.InputView;
import bridge.utils.console.OutputView;
import java.util.List;

public class Application {
    private static InputView input = new InputView();
    private static OutputView output = new OutputView();

    public static void main(String[] args) {
        List<String> bridge = getBridge();

        play(bridge);
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

    private static void play(List<String> bridge) {
        BridgeGame game = new BridgeGame(bridge);

        while (!game.isFinish()) {
            String choiceMove = getChoiceMove();
            showMoveResult(game.move(choiceMove));
        }
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

}
