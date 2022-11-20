package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
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

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame();
    }

    public void play() {
        Length length = createLengthLoop();
        List<String> bridgeNumbers = length.makeBridgeNumbers(bridgeMaker);

        Bridge bridge = createBridge(bridgeNumbers);
        PassingPositions passingPositions = createPassingPositions(bridge);
        Result result = null;

        int distance;
        int attempt = 1;

        game:
        while (true) {
            distance = -1;
            do {
                distance++;
                if (length.isSameLength(distance)) {
                    break game;
                }

                Direction direction = createDirectionLoop();
                Position position = createPosition(distance, direction);
                bridgeGame.move(position, passingPositions);
                result = passingPositions.makeResult();
            } while (!OutputView.printMap(result));

            GameCommand gameCommand = createGameCommandLoop();
            if (gameCommand.isSameQuit()) {
                break;
            }

            bridgeGame.retry(passingPositions);
            attempt++;
        }

        if (result != null) {
            OutputView.printResult(result, attempt);
        }
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
            return new Length(InputView.readBridgeSize());
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
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
            return new Direction(InputView.readMoving());
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
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
            return new GameCommand(InputView.readGameCommand());
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
        }
        return null;
    }


}
