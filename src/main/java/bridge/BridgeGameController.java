package bridge;

import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.printMap;
import static bridge.view.OutputView.printResult;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker;
    private static BridgeGame game;
    private static List<String> bridge;

    public BridgeGameController(int bridgeSize) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
        game = new BridgeGame();
    }

    public static void runBridgeGame() {
        while(true) {
            if(!playOneStep(move()))
                return;
        }
    }

    private static boolean playOneStep(Boolean moveResult) {
        if(!moveResult && readGameCommand().equals("Q")) {
            return endGame("실패");
        }
        if(!moveResult) {
            game.retry();
        }
        if(isGameEnd()) {
            return endGame("성공");
        }
        return true;
    }

    private static Boolean move() {
        Boolean moveResult = game.move(bridge, readMoving());
        printMap(bridge, game.getGameStatus());
        return moveResult;
    }

    private static boolean endGame(String success) {
        printResult(game.getAllCount(), success);
        return false;
    }

    private static boolean isGameEnd() {
        if (bridge.size() == game.getGameStatus().size()) {
            return true;
        }
        return false;
    }

    public static List<String> getBridge() {
        return bridge;
    }
}
