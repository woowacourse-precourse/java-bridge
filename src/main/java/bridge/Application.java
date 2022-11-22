package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static BridgeGame bridgeGame = new BridgeGame();
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    private static String GAME_STATE = "R";
    private static int gameCount = 1;

    private static void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame.bridgeSize = inputView.readBridgeSize();
        BridgeGame.bridge = bridgeMaker.makeBridge(BridgeGame.bridgeSize);
        BridgeGame.userPicks = new ArrayList<>();
        BridgeGame.isCorrect = false;
    }

    private static boolean handleSuccess() {
        if (BridgeGame.index == BridgeGame.bridgeSize && BridgeGame.isCorrect) {
            outputView.printResult(gameCount);
            return true;
        }
        return false;
    }

    private static boolean handleFailure() {
        if (!BridgeGame.isCorrect) {
            GAME_STATE = inputView.readGameCommand();
            if (GAME_STATE == "Q") {
                outputView.printResult(gameCount);
                return true;
            }
            if (GAME_STATE == "R") {
                gameCount++;
                bridgeGame.retry();
                return true;
            }
        }
        return false;
    }

    private static void updateUserPicks() {
        String userPick = inputView.readMoving();
        BridgeGame.userPicks.add(userPick);
    }

    private static void showMap() {
        BridgeGame.isCorrect = bridgeGame.move();
        outputView.printMap();
    }

    public static void main(String[] args) {
        initGame();
        while (!GAME_STATE.equals("Q")) {
            updateUserPicks();
            showMap();
            if (handleSuccess()) return;
            if (handleFailure() && GAME_STATE == "Q") return;
            if (handleFailure() && GAME_STATE == "R") continue;
            BridgeGame.index++;
        }
    }
}
