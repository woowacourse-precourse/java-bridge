package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.ui.Input.InputView;
import bridge.ui.OutputView;

public class Application {

    private static long gameCount = 1;
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static BridgeGame bridgeGame;
    private static final String RETRY = "R";

    public static void main(String[] args) {
        Player player = new Player();
        initializeGame();
        play(player);
        OUTPUT_VIEW.printResult(player, gameCount);
    }

    private static void initializeGame() {
        int bridgeLength = INPUT_VIEW.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker, bridgeLength);
    }

    private static void play(Player player) {
        boolean keepingMoving = true;
        while (keepingMoving) {
            String step = INPUT_VIEW.readMoving();
            boolean stepResult = bridgeGame.move(step, player);
            boolean gameCompletion = bridgeGame.checkGameCompletion(player);
            OUTPUT_VIEW.printMap(player);
            keepingMoving = decideLoop(stepResult, gameCompletion, player);
        }
    }

    private static boolean decideLoop(boolean stepResult, boolean gameCompletion, Player player) {
        if (stepResult) {
            return !gameCompletion;
        }

        return askRetry(player);
    }

    private static boolean askRetry(Player player) {
        if (INPUT_VIEW.readGameCommand().equals(RETRY)) {
            bridgeGame.retry(player);
            gameCount++;
            return true;
        }

        return false;
    }
}
