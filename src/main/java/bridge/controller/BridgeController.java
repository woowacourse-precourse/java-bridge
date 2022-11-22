package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.bridgeInfo.Bridge;
import bridge.domain.userInfo.Direction;
import bridge.domain.userInfo.GameCommand;
import bridge.domain.bridgeInfo.Length;
import bridge.domain.result.PassingPositions;
import bridge.domain.userInfo.Position;
import bridge.domain.result.Result;
import bridge.handler.InputHandler;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame();
        inputHandler = new InputHandler();
        outputView = new OutputView();
    }

    public void startGame() {
        outputView.printStartGame();
        Length length = inputHandler.getLength();
        List<String> bridgeNumbers = length.makeBridgeNumbers(bridgeMaker);
        Bridge bridge = createBridge(bridgeNumbers);
        PassingPositions passingPositions = createPassingPositions(bridge);
        Result result = playGame(length, passingPositions);
        outputView.printResult(result, bridgeGame.getAttemptCount());
    }

    private Result playGame(Length length, PassingPositions passingPositions) {
        Result result = null;
        while (true) {
            result = playEachRound(length, passingPositions, result);
            if (isStopGame(length, result)) {
                break;
            }
            bridgeGame.retry(passingPositions);
        }
        return result;
    }

    private boolean isStopGame(Length length, Result result) {
        return result.isSameDistanceAndLength(length) || isUserWantQuit();
    }

    private boolean isUserWantQuit() {
        GameCommand gameCommand = inputHandler.getGameCommand();
        return gameCommand.isSameQuit();
    }

    private Result playEachRound(Length length, PassingPositions passingPositions, Result result) {
        int distance = -1;
        do {
            if (length.isSameLength(++distance)) {
                return result;
            }
            result = getResult(passingPositions, distance);
        } while (!outputView.printMap(result));
        result.rollbackDistance();
        return result;
    }

    private Result getResult(PassingPositions passingPositions, int distance) {
        Result result;
        Direction direction = inputHandler.getDirection();
        Position position = createPosition(distance, direction);
        bridgeGame.move(position, passingPositions);
        result = passingPositions.makeResult(distance);
        return result;
    }

    private Bridge createBridge(List<String> bridgeNumbers) {
        try {
            return new Bridge(bridgeNumbers);
        } catch (IllegalStateException ex) {
            outputView.printError(ex.getMessage());
        }
        return null;
    }

    private PassingPositions createPassingPositions(Bridge bridge) {
        return new PassingPositions(bridge);
    }

    private Position createPosition(int distance, Direction direction) {
        return new Position(distance, direction);
    }
}
