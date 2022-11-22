package bridge;

import bridge.model.BridgeMap;

import java.util.List;

public class GameManager {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    BridgeGame bridgeGame;

    public void initGame() {
        outputView.printGameStart();
        bridgeGame = new BridgeGame(BridgeMap.generateMap(), createBridge());
        Round round = new Round();

        startGame(round);

        outputView.printResult(bridgeGame.getBridgeMap(), round);
    }

    private void startGame(Round round) {
        while (true) {
            if (playRound(round) == false) {
                round.recordResult(false);
                break;
            }
            if (bridgeGame.isEnd()) {
                round.recordResult(true);
                break;
            }
        }
    }

    private boolean playRound(Round round) {
        if (!askMove()) {
            if (!askRetry()) {
                return false;
            }
            round.addTryCount();
            bridgeGame.retry();
        }
        return true;
    }

    private List<String> createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        while (true) {
            outputView.askBridgeSize();
            try {
                return bridgeMaker.makeBridge(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
