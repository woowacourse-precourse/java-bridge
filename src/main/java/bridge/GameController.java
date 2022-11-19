package bridge;

import bridge.constant.Game;

import java.util.List;

public class GameController {
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private boolean success = false;

    public void start() {
        int attempts = 1;
        outputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());
        while (!startCrossBridge(bridge) && bridgeGame.retry().equals("Q")) {
            attempts++;
        }
        getGameResult(attempts);
    }

    private int getBridgeSize() {
        InputView inputView = new InputView();
        return inputView.readBridgeSize();
    }

    private boolean startCrossBridge(List<String> bridge) {
        int count;
        this.bridgeGame = new BridgeGame(bridge);

        count = countRightMove(bridge);

        if (bridge.size() == count){
            success = true;
            return true;
        }

        return false;
    }

    private void getGameResult(int attempts) {
        outputView.printResult();
        outputView.printMap(bridgeGame.getResult());
        outputView.printSuccess(success);
        outputView.printAttempts(attempts);
    }

    private int countRightMove(List<String> bridge) {
        int count;
        InputView inputView = new InputView();
        for (count = 0; count < bridge.size(); count++) {
            if (!bridgeGame.move(inputView.readMoving(), count)) {
                outputView.printMap(bridgeGame.getResult());
                return count;
            }
            outputView.printMap(bridgeGame.getResult());
        }

        return count;
    }
}