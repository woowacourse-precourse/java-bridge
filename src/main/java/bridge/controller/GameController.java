package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.bridge.Node;
import bridge.view.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final BridgeGame game = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
        output.printStart();
        int bridgeSize = input.readBridgeSize();
        game.init(bridgeSize);
        while (game.isEnd()) {
            goOneStep();
        }
        output.printResult();
    }

    private static void goOneStep() {
        moveAndPrintResult();
        if (game.lastChoiceMismatch()) {
            quitOrRetry();
        }
    }

    private static void moveAndPrintResult() {
        Node to = input.readMoving();
        game.move(to);
        // TODO: map 만들어와서 printMap() 인자로 넣어주기
//        output.printMap();
    }

    private static void quitOrRetry() {
        GameCommand command = input.readGameCommand();
        if (wantToQuit(command)) {
            game.quit();
            return;
        }
        game.retry();
    }

    private static boolean wantToQuit(GameCommand command) {
        return command == GameCommand.QUIT;
    }
}
