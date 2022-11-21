package bridge;

import bridge.ioView.InputView;
import bridge.ioView.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    public void simulateGame() {
        int bridgeSize = initializeGame();
        List<String> bridge = makeBridge(bridgeSize);
        List<String> userRoute = new ArrayList<>();
        int trial = 0;

        do {
            trial++;
            startGameRound(userRoute, bridge);
        } while (gameover(userRoute, bridge));
        quitGame(trial, userRoute, bridge);
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

    private List<String> startGameRound(List<String> userRoute, List<String> bridge) {
        while (!bridgeGame.checkCrossingBridge(userRoute, bridge)) {
            String moving = inputView.readMoving();
            userRoute.add(moving);
            outputView.printMap(userRoute, bridge);

            if(!bridgeGame.move(moving, bridge)) {
                break;
            }
        }
        return userRoute;
    }

    /**
     * 게임 한 라운드가 끝난 뒤 game clear 체크 및 game retry를 한다.
     * @return 재시작 여부
     */
    private boolean gameover(List<String> userRoute, List<String> bridge) {
        if(bridgeGame.checkCrossingBridge(userRoute, bridge)) {
            return false;
        }

        if(inputView.readGameCommand()) {
            bridgeGame.retry(userRoute);
            return true;
        }

        return false;
    }

    private void quitGame(int trial, List<String> userRoute, List<String> bridge) {
        outputView.printResult(trial, bridge, userRoute);
    }
}
