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
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        Length length = null;
        do {
            try {
                length = new Length(InputView.readBridgeSize());
            } catch (IllegalArgumentException ex) {
                OutputView.printError(ex.getMessage());
            }
        } while (length == null);

        int size = length.getLength();
        List<String> bridgeNumbers = bridgeMaker.makeBridge(size);

        Bridge bridge = new Bridge(bridgeNumbers);
//        bridge.getDirections().stream()
//                .map(Direction::getDirection)
//                .forEach(System.out::println);

        BridgeGame bridgeGame = new BridgeGame();
        boolean isQuit = false;
        int pos;
        int attempt = 1;

        PassingPositions passingPositions = new PassingPositions(bridge);
        Result result = null;

        game:
        while (true) {
            pos = -1;
            do {
                pos++;
                if (pos == size) {
                    isQuit = true;
                    break;
                }

                Direction direction = null;
                do {
                    try {
                        direction = new Direction(InputView.readMoving());
                    } catch (IllegalArgumentException ex) {
                        OutputView.printError(ex.getMessage());
                    }
                } while (direction == null);

                Position position = new Position(pos, direction);
                bridgeGame.move(position, passingPositions);
                result = passingPositions.makeResultsGroup();
            } while (!OutputView.printMap(result));

            if (isQuit) {
                break;
            }

            GameCommand gameCommand = null;
            do {
                try {
                    gameCommand = new GameCommand(InputView.readGameCommand());
                    if (gameCommand.isQuit()) {
                        break game;
                    }
                } catch (IllegalArgumentException ex) {
                    OutputView.printError(ex.getMessage());
                }
            } while (gameCommand == null);

            bridgeGame.retry(passingPositions);
            attempt++;
        }

        if (result != null) {
            OutputView.printResult(result, attempt);
        }
    }
}
