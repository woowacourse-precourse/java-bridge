package bridge.Service;

import bridge.Model.BridgeShape;
import bridge.Model.GameResult;

public class InputValidator {

    private static int MIN_SIZE = 3;
    private static int MAX_SIZE = 20;
    public static final String UP = BridgeShape.UP.getShape();
    public static final String DOWN = BridgeShape.DOWN.getShape();
    public static final String RETRY = GameResult.RETRY.getResult();
    public static final String QUIT = GameResult.QUIT.getResult();

    public void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateDigit(String input) {
        boolean result = input.chars()
                .allMatch(Character::isDigit);

        if (result == false) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateMoving(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
