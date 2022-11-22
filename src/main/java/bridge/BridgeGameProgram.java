package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.io.InputView;
import bridge.io.Message;
import bridge.io.OutputView;
import bridge.utils.GameCommand;
import bridge.utils.GameStatus;
import bridge.utils.Mark;

import java.util.List;

public class BridgeGameProgram {
    private final InputView input;
    private final OutputView output;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeGameProgram(InputView input, OutputView output, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.input = input;
        this.output = output;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        Bridge bridge = initGame();
        while (GameStatus.isRunning) {
            Mark mark = match(bridge);
            List<List<String>> route = bridgeGame.move(mark);
            output.printMap(route);
            checkFail(mark, route);
            checkSuccess(bridge, route);
        }
    }

    private Bridge initGame() {
        output.printMessage(Message.START);
        List<String> bridgeRoute = bridgeMaker.makeBridge(getBridgeSize());
        return new Bridge(bridgeRoute);
    }

    private Mark match(Bridge bridge) {
        return bridge.matchRoute(getInputDirection(), bridgeGame.countMoving());
    }

    private void checkFail(Mark mark, List<List<String>> route) {
        if (!mark.isRight()) {
            restartOrStop(route);
        }
    }

    private void restartOrStop(List<List<String>> route) {
        if (getGameCommand().equals(GameCommand.END.getCommand())) {
            endGame(route, Message.FAIL);
            return;
        }
        bridgeGame.retry();
    }

    private void checkSuccess(Bridge bridge, List<List<String>> route) {
        if (bridge.isLast(bridgeGame.getMovingCount())) {
            endGame(route, Message.SUCCESS);
        }
    }

    private void endGame(List<List<String>> route, Message result) {
        GameStatus.quitGame();
        output.printResult(route, result, bridgeGame.getGameCount());
    }

    private int getBridgeSize() {
        while (true) {
            try {
                output.printMessage(Message.REQUEST_BRIDGE_SIZE);
                return input.readBridgeSize();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private String getInputDirection() {
        while (true) {
            try {
                output.printMessage(Message.REQUEST_DIRECTION);
                return input.readMoving();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private String getGameCommand() {
        while (true) {
            try {
                output.printMessage(Message.RESTART_OR_EXIT);
                return input.readGameCommand();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}

