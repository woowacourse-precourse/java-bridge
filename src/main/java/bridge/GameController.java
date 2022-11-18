package bridge;

import bridge.constant.Game;

import java.util.List;

public class GameController {
    BridgeGame bridgeGame;
    int attempts = 1;
    boolean success = false;
    OutputView outputView = new OutputView();

    public void start() {
//        System.out.println(Game.START_GAME_MESSAGE);
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while (true) {
            if (startCrossBridge(bridge)) {
                break;
            }

            String commend = bridgeGame.retry();
            if (commend.equals("Q")) {
                break;
            } else if (commend.equals("R")) {
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
        int count;
        this.bridgeGame = new BridgeGame(bridge);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        for (count = 0; count < bridge.size(); count++) {
            String moving = inputView.readMoving();
            if (!bridgeGame.move(moving, count)) {
                outputView.printMap(bridgeGame.getResult());
                return false;
            }
            outputView.printMap(bridgeGame.getResult());
        }

        if (bridge.size() == count){
            success = true;
            return true;
        }

        return false;
    }

    private void getGameResult() {
        OutputView outputView = new OutputView();

        outputView.printResult();
        outputView.printMap(bridgeGame.getResult());
        outputView.printSuccess(success);
        outputView.printAttempts(attempts);
    }
}