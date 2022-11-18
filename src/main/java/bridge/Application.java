package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.Constants.*;
import static bridge.message.Message.START;

public class Application {

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void main(String[] args) {
        try {
            System.out.println(START);
            int bridgeSize = input.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

            Player player = new Player(bridge);
            boolean isGameEnd = false;
            while (true) {
                String direction = input.readMoving();

                boolean isPossible = bridgeGame.move(player, direction);
                output.printMap(player);
                if (isPossible) {
                    if (player.isGameEnd()) {
                        isGameEnd = true;
                        break;
                    }
                    continue;
                }

                String command = input.readGameCommand();
                if (command.equals(QUIT)) {
                    break;
                }
                bridgeGame.retry(player);
            }

            output.printResult(player, isGameEnd);
        } catch (IllegalArgumentException e) {
            output.printExceptionMessage(e);
        }

    }
}
