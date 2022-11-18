package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final BridgeGame game = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
        int bridgeSize = input.readBridgeSize();
        game.init(bridgeSize);
        while (true) {
            String to = input.readMoving();
            game.move(to);
            output.printMap();
            if (!game.survived()) {
                String command = input.readGameCommand();
                if (command.equals("Q")) {
                    break;
                }
                game.retry();
            }
        }
        output.printResult();
    }
}
