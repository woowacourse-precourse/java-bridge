package bridge;

import java.util.List;

public class GameController {
    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        startCrossBridge(bridgeMaker.makeBridge(bridgeSize));
        getGameResult();
    }

    private int getBridgeSize() {
        InputView inputView = new InputView();
        return inputView.readBridgeSize();
    }

    private void startCrossBridge(List<String> bridge) {
        int count = 0;
        BridgeGame bridgeGame = new BridgeGame(bridge);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        while (true) {
            String moving = inputView.readMoving();
            if (!bridgeGame.move(moving, count++)) {
                outputView.printMap(bridgeGame.getResult());
                break;
            }
            outputView.printMap(bridgeGame.getResult());
        }
    }

    private void getGameResult() {

    }
}