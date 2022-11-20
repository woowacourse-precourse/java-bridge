package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.domain.Length;
import bridge.domain.PassingPositions;
import bridge.domain.Position;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        Length length = createLengthLoop();
        List<String> bridgeNumbers = length.makeBridgeNumbers(bridgeMaker);
        Bridge bridge = createBridge(bridgeNumbers);
        PassingPositions passingPositions = createPassingPositions(bridge);
        Result result = null;
        int attempt = 1;

        while (true) {
            result = playEachRound(length, passingPositions, result);
            if (length.isSameLength(result.getDistance())) {
                break;
            }
            GameCommand gameCommand = createGameCommandLoop();
            if (gameCommand.isSameQuit()) {
                break;
            }
            bridgeGame.retry(passingPositions);
            attempt++;
        }
            outputView.printResult(result, attempt);
    }

    private Result playEachRound(Length length, PassingPositions passingPositions, Result result) {
        int distance = -1;
        do {
            if (length.isSameLength(++distance)) {
                return result;
            }
            Direction direction = createDirectionLoop();
            Position position = createPosition(distance, direction);
            bridgeGame.move(position, passingPositions);
            result = passingPositions.makeResult(distance);
        } while (!outputView.printMap(result));
        result.setDistance(--distance);
        return result;
    }

    private Length createLengthLoop() {
        Length length;
        do {
            length = createLength();
        } while (length == null);
        return length;
    }

    private Length createLength() {
        try {
            return new Length(inputView.readBridgeSize());
        } catch (IllegalArgumentException ex) {
            outputView.printError(ex.getMessage());
        }
        return null;
    }

    private Bridge createBridge(List<String> bridgeNumbers) {
        return new Bridge(bridgeNumbers);
    }

    private PassingPositions createPassingPositions(Bridge bridge) {
        return new PassingPositions(bridge);
    }

    private Direction createDirectionLoop() {
        Direction direction;
        do {
            direction = createDirection();
        } while (direction == null);
        return direction;
    }

    private Direction createDirection() {
        try {
            return new Direction(inputView.readMoving());
        } catch (IllegalArgumentException ex) {
            outputView.printError(ex.getMessage());
        }
        return null;
    }

    private Position createPosition(int pos, Direction direction) {
        return new Position(pos, direction);
    }

    private GameCommand createGameCommandLoop() {
        GameCommand gameCommand;
        do {
            gameCommand = createGameCommand();
        } while (gameCommand == null);
        return gameCommand;
    }

    private GameCommand createGameCommand() {
        try {
            return new GameCommand(inputView.readGameCommand());
        } catch (IllegalArgumentException ex) {
            outputView.printError(ex.getMessage());
        }
        return null;
    }


}
