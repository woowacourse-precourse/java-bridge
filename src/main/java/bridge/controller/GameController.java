package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.RealTimeBridge;
import bridge.domain.Result;
import bridge.utils.InputHandler;
import bridge.view.OutputView;

public class GameController {

    private final InputHandler inputHandler = new InputHandler();
    private final RealTimeBridge realTimeBridge = new RealTimeBridge();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final String[][] realTimeMap = realTimeBridge.getMap();

    public void runGame() {
        outputView.printStartMessage();
        int size = inputHandler.getBridgeSize();
        Bridge bridge = new Bridge(size);
        while (bridgeGame.keepPlayingIndex && bridgeGame.bridgeIndex < size) {
            play(bridge);
        }
        String gameResult = new Result().returnResult(bridgeGame.keepPlayingIndex);
        outputView.printResult(gameResult, bridgeGame.count, realTimeMap);
    }

    private void play(Bridge bridge) {
        String userMove = inputHandler.getMoving();
        if (isCorrect(bridge, userMove)) {
            return;
        }
        isWrong(userMove);
    }

    private void isWrong(String userMove) {
        stopPlaying(userMove);
        String command = inputHandler.getGameCommand();
        if (bridgeGame.retry(command)) {
            initialize();
        }
    }

    private boolean isCorrect(Bridge bridge, String userMove) {
        if (bridgeGame.move(userMove, bridge.get(bridgeGame.bridgeIndex))) {
            keepPlaying(userMove);
            return true;
        }
        return false;
    }

    private void initialize() {
        realTimeBridge.initialize();
    }

    private void stopPlaying(String userMove) {
        realTimeBridge.makeWrongMap(userMove);
        outputView.printMap(realTimeMap);
    }

    private void keepPlaying(String userMove) {
        realTimeBridge.makeCorrectMap(userMove);
        outputView.printMap(realTimeMap);
    }
}