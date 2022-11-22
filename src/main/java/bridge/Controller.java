package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static List<String> bridge;
    private static int count;
    private static boolean game;
    private static int challengeCount;

    private void init() {
        count = 0;
        game = true;
        challengeCount = 1;
    }

    public void readyBridgeGame(BridgeMaker bridgeMaker) {
        init();
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        startGame();
    }

    public void startGame() {
        while (game) {
            String moving = inputView.readMoving();
            game = bridgeGame.move(bridge, moving, count);
            count++;
            if (game == false) {
                game = manageGameState();
            }
            if (game == true && count == bridge.size()) {
                outputView.printResult(challengeCount, game);
                game = false;
            }
        }
    }
    private boolean manageGameState() {
        game = bridgeGame.retry(inputView.readGameCommand());
        if (game == true) {
            wantRestart();
        }
        if (game == false) {
            wantQuit();
        }
        return game;
    }

    private void wantRestart() {
        count = 0;
        challengeCount++;
    }

    private void wantQuit() {
        outputView.printResult(challengeCount, game);
    }
}
