package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private static String RETRY_GAME = "R";
    private static String END_GAME = "Q";

    public static BridgeGame game = new BridgeGame();

    public void run() {
        try {
            List<String> bridge = createBridge();
            play(bridge, game);
            OutputView.printResult(bridge, game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> createBridge() {
        OutputView.printStart();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(InputView.readBridgeSize());
    }

    private void play(List<String> bridge, BridgeGame game) {
        do {
            boolean roundResultSuccess = crossBridge(bridge, game);
            if (!roundResultSuccess) {
                retryOrExit(InputView.readGameCommand(), game);
            }
        } while (!game.isEnd(bridge));
    }

    private boolean crossBridge(List<String> bridge, BridgeGame game) {
        boolean roundResult = game.move(bridge, InputView.readMoving());
        OutputView.printMap(bridge, game.getMovingResult());
        return roundResult;
    }

    private void retryOrExit(String command, BridgeGame game) {
        if (RETRY_GAME.equals(command)) {
            game.retry();
        }
        if (END_GAME.equals(command)) {
            game.end();
        }
    }
}
