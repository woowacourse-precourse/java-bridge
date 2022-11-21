package bridge;

import bridge.domain.game.BridgeGame;
import bridge.io.InputView;
import bridge.io.OutputView;

public class Application {
    private static final String QUIT_COMMAND = "Q";

    private static BridgeGame game;

    public static void main(String[] args) {
        OutputView.printStartPhrase();
        makeBridgeGame();
        playGame();
        printResult();
    }

    private static void makeBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        game = new BridgeGame(bridgeMaker.makeBridge(InputView.readBridgeSize()));
    }

    private static void playGame() {
        while (!game.isEnd()) {
            moveMap();
            if (isAskedToQuit(game.isStopped()))
                return ;
            if (game.isStopped())
                game.retry();
        }
    }

    private static void moveMap() {
        game.move(InputView.readMoving());
        OutputView.printMap(game.getResult());
    }

    private static boolean isAskedToQuit(boolean isStopped) {
        if (!isStopped)
            return false;
        return InputView.readGameCommand().equals(QUIT_COMMAND);
    }

    private static void printResult() {
        OutputView.printResult(game.getResult(), game.isEnd());
    }
}
