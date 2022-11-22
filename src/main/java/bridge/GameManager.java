package bridge;

import bridge.model.BridgeMap;

import java.util.List;

public class GameManager {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;

    public void initGame() {
        outputView.printGameStart();

        bridgeGame = new BridgeGame(BridgeMap.generateMap(), createBridge());

        int tryCount = 1;
        boolean gameStatus = true;

        while (!bridgeGame.isEnd()) {
            if (!askMove()) {
                if (askRetry()) {
                    tryCount++;
                    bridgeGame.retry();
                } else {
                    gameStatus=false;
                    break;
                }
            }
        }

        outputView.printResult(bridgeGame.getBridgeMap(),tryCount,gameStatus);

    }

    private List<String> createBridge() {
        while (true) {
            outputView.askBridgeSize();
            try {
                return bridgeMaker.makeBridge(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private boolean askMove() {
        while (true) {
            outputView.askMove();
            try {
                boolean result = bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame.getBridgeMap());
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private boolean askRetry() {
        while (true) {
            outputView.askRestart();
            try {
                return isRestart();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private boolean isRestart() {
        String result = inputView.readGameCommand();
        if (result.equals("R")) {
            return true;
        }
        return false;
    }
}
