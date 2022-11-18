package bridge;

import java.util.List;

public class GameController {
    BridgeGame bridgeGame;
    int attempts = 1;
    boolean success = false;

    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        while (true) {
            if (startCrossBridge(bridgeMaker.makeBridge(bridgeSize))) {
                break;
            }

            if (bridgeGame.retry().equals("Q")) {
                break;
            } else if (bridgeGame.retry().equals("R")) {
                attempts++;
            }
        }
        getGameResult();
    }

    private int getBridgeSize() {
        InputView inputView = new InputView();
        return inputView.readBridgeSize();
    }

    private boolean startCrossBridge(List<String> bridge) {
        int count = 0;
        this.bridgeGame = new BridgeGame(bridge);
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