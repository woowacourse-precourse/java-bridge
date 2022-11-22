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
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> userPicks = new ArrayList<>();
        boolean isCorrect = false;
        while (!GAME_STATE.equals("Q")) {
            String userPick = inputView.readMoving();
            userPicks.add(userPick);
            isCorrect = bridgeGame.move(bridge, userPicks);
            outputView.printMap(bridge, userPicks, isCorrect);
            if (index == bridgeSize && isCorrect) {
                outputView.printResult(bridge, userPicks, true, gameCount);
                return;
            }
            if (!isCorrect) {
                GAME_STATE = inputView.readGameCommand();
                if (GAME_STATE == "Q") {
                    outputView.printResult(bridge, userPicks, false, gameCount);
                    return;
                }
                if (GAME_STATE == "R") gameCount++;
            }
            index++;
        }

    }
}
