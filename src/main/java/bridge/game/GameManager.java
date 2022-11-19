package bridge.game;

import bridge.domain.GameResult;
import bridge.domain.GameSession;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameManager {
    private final InputView input;
    private final OutputView output;
    private boolean newGame = true;
    private GameSession gameSession;
    BridgeGame game = new BridgeGame();

    public GameManager(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }


    public void run() {
        while (newGame) {
            gameSequence();
        }
    }

    private void gameSequence() {
        List<String> bridge = initGame();

        while (!gameSession.isArrived()) {
            if (moveAndCheck(bridge)) {
                break;
            }
        }
    }

    private List<String> initGame() {
        output.printStart();
        output.printInputLength();
        int bridgeSize = input.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        gameSession = new GameSession(bridge);
        return bridge;
    }

    private boolean moveAndCheck(List<String> bridge) {
        inputAndPrintStep(bridge);
        if (checkMoveSucceed(bridge)) {
            return true;
        }
        if (checkArrival(bridge)) {
            handleArrival(bridge);
            return true;
        }
        return false;
    }

    private void inputAndPrintStep(List<String> bridge) {
        output.printInputChooseCell();
        String move = input.readMoving();
        game.move(gameSession, move);
        output.printMap(bridge, gameSession.getStep());
    }

    private void handleArrival(List<String> bridge) {
        output.printResult(bridge, gameSession, GameResult.succeed);
        newGame = false;
    }

    private boolean checkArrival(List<String> bridge) {
        return gameSession.isArrived();
    }

    private boolean checkMoveSucceed(List<String> bridge) {
        if (!gameSession.isMoveSuccess()) {
            output.printChooseRetry();
            String command = input.readGameCommand();
            boolean isRetry = game.retry(command, gameSession);
            if (failAndQuit(bridge, isRetry)) {
                return true;
            }
        }
        return false;
    }

    private boolean failAndQuit(List<String> bridge, boolean isRetry) {
        if (!isRetry) {
            output.printResult(bridge, gameSession, GameResult.fail);
            newGame = false;
            return true;
        }
        return false;
    }
}
