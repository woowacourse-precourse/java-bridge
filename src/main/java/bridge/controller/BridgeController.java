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

    public void play() {
        BridgeNumberGenerator bridgeNumberGenerator = createBridgeNumberGenerator();
        BridgeMaker bridgeMaker = createBridgeMaker(bridgeNumberGenerator);

        Length length = null;
        length = createLengthLoop(length);
        int size = length.getLength();
        List<String> bridgeNumbers = bridgeMaker.makeBridge(size);

        Bridge bridge = createBridge(bridgeNumbers);
//        bridge.getDirections().stream()
//                .map(Direction::getDirection)
//                .forEach(System.out::println);

        BridgeGame bridgeGame = createBridgeGame();
        boolean isQuit = false;
        int pos;
        int attempt = 1;

        PassingPositions passingPositions = createPassingPositions(bridge);
        Result result = null;

//        game:
        while (true) {
            pos = -1;
            do {
                pos++;
                if (pos == size) {
                    isQuit = true;
                    break;
                }

                Direction direction = null;
                direction = createDirectionLoop(direction);

                Position position = createPosition(pos, direction);
                bridgeGame.move(position, passingPositions);
                result = passingPositions.makeResultsGroup();
            } while (!OutputView.printMap(result));

            if (isQuit) {
                break;
            }

            GameCommand gameCommand = null;
            gameCommand = createGameCommandLoop(gameCommand);

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

    
    private BridgeNumberGenerator createBridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private BridgeMaker createBridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        return new BridgeMaker(bridgeNumberGenerator);
    }

    private Length createLengthLoop(Length length) {
        do {
            length = createLength(length);
        } while (length == null);
        return length;
    }

    private Length createLength(Length length) {
        try {
            length = new Length(InputView.readBridgeSize());
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
        }
        return length;
    }

    private Bridge createBridge(List<String> bridgeNumbers) {
        return new Bridge(bridgeNumbers);
    }

    private BridgeGame createBridgeGame() {
        return new BridgeGame();
    }

    private PassingPositions createPassingPositions(Bridge bridge) {
        return new PassingPositions(bridge);
    }

    private Direction createDirectionLoop(Direction direction) {
        do {
            direction = createDirection(direction);
        } while (direction == null);
        return direction;
    }

    private Direction createDirection(Direction direction) {
        try {
            direction = new Direction(InputView.readMoving());
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
        }
        return direction;
    }

    private Position createPosition(int pos, Direction direction) {
        return new Position(pos, direction);
    }

    private GameCommand createGameCommandLoop(GameCommand gameCommand) {
        do {
            gameCommand = createGameCommand(gameCommand);
        } while (gameCommand == null);
        return gameCommand;
    }

    private GameCommand createGameCommand(GameCommand gameCommand) {
        try {
            gameCommand = new GameCommand(InputView.readGameCommand());
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
        }
        return gameCommand;
    }


}
