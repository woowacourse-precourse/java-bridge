package bridge.handler;

import bridge.domain.game.Length;
import bridge.domain.game.Direction;
import bridge.domain.game.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputHandler {

    private final InputView inputView;
    private final OutputView outputView;

    public InputHandler() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public Length getLength() {
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

    public Direction getDirection() {
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

    public GameCommand getGameCommand() {
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
