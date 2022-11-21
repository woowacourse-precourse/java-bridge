package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static BridgeGame bridgeGame;
    private static BridgeMaker bridgeMaker;
    private static InputView inputView;
    private static OutputView outputView;

    private static String GAME_STATE = "R";
    private static int gameCount = 1;
    private static int index = 0;

    Application() {
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> userPicks = new ArrayList<>();
        while(!GAME_STATE.equals("Q")) {
            String userPick = inputView.readMoving();
            userPicks.add(userPick);
            boolean isCorrect = bridgeGame.move(bridge, userPicks);
            outputView.printMap(bridge, userPicks);
            if(!isCorrect) GAME_STATE = inputView.readGameCommand();
        }
    }
}
