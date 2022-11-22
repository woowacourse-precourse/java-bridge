package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.Constants.QUIT;

public class Application {

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void main(String[] args) {
        output.printStart();

        Player player = createPlayer();

        playBridgeGame(player);

        output.printResult(player);
    }

    private static Player createPlayer() {
        List<String> bridge = requestBridge();
        return new Player(bridge);
    }

    private static void playBridgeGame(Player player) {
        while (!player.isGameEnd()) {
            boolean isPossible = requestMoving(player);

            if (isPossible) {
                continue;
            }
            if (isQuit(player)) {
                break;
            }
        }
    }

    private static boolean isQuit(Player player) {
        String gameCommand = requestGameCommand();
        if (gameCommand.equals(QUIT)) {
            return true;
        }
        bridgeGame.retry(player);
        return false;
    }

    private static String requestGameCommand() {
        while (true) {
            try {
                return input.readGameCommand();
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e);
            }
        }
    }

    private static boolean requestMoving(Player player) {
        while (true) {
            try {
                String direction = input.readMoving();
                boolean isPossible = bridgeGame.move(player, direction);

                output.printMap(player);
                return isPossible;
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e);
            }
        }
    }

    private static List<String> requestBridge() {
        while (true) {
            try {
                int bridgeSize = input.readBridgeSize();
                return bridgeMaker.makeBridge(bridgeSize);
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e);
            }
        }
    }
}
