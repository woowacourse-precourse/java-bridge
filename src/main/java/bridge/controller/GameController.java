package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.bridgeenum.Restart;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private boolean isPlaying;
    private int tryCount;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        startNewGame();
    }

    public void play() {
        while (isPlaying) {
            move();
            printMoveResult();
            checkGameEnd();
        }
        printFinalResult();
    }

    private void startNewGame() {
        printGameStart();
        bridgeGame = new BridgeGame(createNewBridge());
        isPlaying = true;
        tryCount = 1;
    }

    private Bridge createNewBridge() {
        while (true) {
            try {
                return new Bridge(generateBridge());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void move() {
        String nextPosition;
        while (true) {
            try {
                nextPosition = inputView.readMoving();
                bridgeGame.move(nextPosition);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void printGameStart() {
        outputView.printStart();
    }

    private List<String> generateBridge() {
        return bridgeMaker.makeBridge(requestBridgeLength());
    }

    private int requestBridgeLength() {
        return inputView.readBridgeSize();
    }

    private void printMoveResult() {
        outputView.printMap(bridgeGame.getCurrentMap());
    }

    private void checkGameEnd() {
        if (bridgeGame.isGameOver()) {
            requestGameRestart();
            return;
        }
        if (bridgeGame.isGamePass()) {
            isPlaying = false;
        }
    }

    private void requestGameRestart() {
        String restartCommand;
        while (true) {
            try {
                restartCommand = inputView.readGameCommand();
                checkGameRestart(restartCommand);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void checkGameRestart(String command) {
        isPlaying = Restart.isRestart(command);
        if (isPlaying) {
            bridgeGame.retry();
            tryCount += 1;
        }
    }

    private void printFinalResult() {
        outputView.printResult(bridgeGame.getCurrentMap(), tryCount, bridgeGame.isGamePass());
    }

}
