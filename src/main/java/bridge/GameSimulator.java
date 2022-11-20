package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    public void simulateGame() {
        int bridgeSize = initializeGame();
        List<String> bridge = makeBridge(bridgeSize);
        List<String> userRoute;
        int trial = 0;

        do {
            trial++;
            userRoute = startGame(bridge);
        } while (!bridgeGame.gameClear(userRoute.size(), bridgeSize) && bridgeGame.gameover());
        quitGame(trial, bridge, userRoute);
    }

    /**
     * 게임 시작 세팅 출력 및 다리 길이를 입력 받는다.
     */
    private int initializeGame() {
        outputView.printGameStart();
        return inputView.readBridgeSize();
    }

    private List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private List<String> startGame(List<String> bridge) {
        List<String> userRoute = new ArrayList<>();

        String moving;
        while (!bridgeGame.checkCrossingBridge(userRoute, bridge) &&
                (moving = bridgeGame.move(bridge)) != null) {
            userRoute.add(moving);
        }

        return userRoute;
    }

    private void quitGame(int trial, List<String> bridge, List<String> userRoute) {
        outputView.printResult(trial, bridge, userRoute);
    }
}
