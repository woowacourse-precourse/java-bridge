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
    private static int index = 1;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame.bridgeSize = inputView.readBridgeSize();
        BridgeGame.bridge = bridgeMaker.makeBridge(BridgeGame.bridgeSize);
        BridgeGame.userPicks = new ArrayList<>();
        BridgeGame.isCorrect = false;
        while (!GAME_STATE.equals("Q")) {
            String userPick = inputView.readMoving();
            BridgeGame.userPicks.add(userPick);
            BridgeGame.isCorrect = bridgeGame.move();
            outputView.printMap();
            if (index == BridgeGame.bridgeSize && BridgeGame.isCorrect) {
                outputView.printResult(gameCount);
                return;
            }
            if (!BridgeGame.isCorrect) {
                GAME_STATE = inputView.readGameCommand();
                if (GAME_STATE == "Q") {
                    outputView.printResult(gameCount);
                    return;
                }
                if (GAME_STATE == "R") gameCount++;
            }
            index++;
        }

    }
}
