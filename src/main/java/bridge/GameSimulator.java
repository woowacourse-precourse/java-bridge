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
            userRoute = startGameRound(bridge);
        } while (gameover(bridge));
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

    private List<String> startGameRound(List<String> bridge) {
        List<String> userRoute = new ArrayList<>();

        String moving = inputView.readMoving();
        while (!bridgeGame.checkCrossingBridge(bridge) && bridgeGame.move(moving, bridge)) {
            userRoute.add(moving);
        }

        return userRoute;
    }

    /**
     * 게임 한 라운드가 끝난 뒤 game clear 체크 및 game retry를 한다.
     * @param bridge
     * @return 재시작 여부
     */
    private boolean gameover(List<String> bridge) {
        if(bridgeGame.checkCrossingBridge(bridge)) {
            return false;
        }

        if(inputView.readGameCommand()) {
            bridgeGame.retry();
            return true;
        }

        return false;
    }

    private void quitGame(int trial, List<String> bridge, List<String> userRoute) {
        outputView.printResult(trial, bridge, userRoute);
    }
}
