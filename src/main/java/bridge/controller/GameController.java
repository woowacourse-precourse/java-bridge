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

    private boolean isAnswer = true;
    private int count = 1;
    private int index = 0;

    public void runGame() {
        outputView.printStartMessage();
        int size = inputHandler.getBridgeSize();
        Bridge bridge = new Bridge(size);
        while (isAnswer && index < size) {
            play(bridge);
        }
        String gameResult = new Result().returnResult(isAnswer);
        outputView.printResult(gameResult, count, realTimeMap);
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
        if (bridgeGame.move(userMove, bridge.get(index))) {
            keepPlaying(userMove);
            return true;
        }
        return false;
    }

    private void initialize() {
        count++;
        realTimeBridge.initialize();
        index = 0;
        isAnswer = true;
    }

    private void stopPlaying(String userMove) {
        realTimeBridge.makeWrongMap(userMove);
        outputView.printMap(realTimeMap);
        isAnswer = false;
    }

    private void keepPlaying(String userMove) {
        realTimeBridge.makeCorrectMap(userMove);
        outputView.printMap(realTimeMap);
        index++;
    }
}