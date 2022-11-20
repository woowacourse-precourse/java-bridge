package bridge.domain;

public class Checker {
    private static final Checker checker = new Checker();
    private final int MAXIMUM_BRIDGE_SIZE = 20;
    private final int MINIMUM_BRIDGE_SIZE = 3;
    private final String MOVING_UP = "U";
    private final String MOVING_DOWN = "D";
    private final String GAME_RESTART = "R";
    private final String GAME_QUIT = "Q";

    private Checker() {}

    static Checker getInstance() {
        return checker;
    }

    void validateBridgeSize(String bridgeSize) {
        try {
            if (!checkBridgeSizeRange(Integer.parseInt(bridgeSize))) {
                throw new IllegalArgumentException(InputExceptionMessage.WRONG_BRIDGE_SIZE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    void validateMoving(String moving) {
        if (!checkMovingValue(moving)) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_MOVING.getMessage());
        }
    }

    void validateGameCommand(String gameCommand) {
        if (!checkGameCommandValue(gameCommand)) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_GAME_COMMAND.getMessage());
        }
    }

    private boolean checkBridgeSizeRange(int bridgeSize) {
        return MINIMUM_BRIDGE_SIZE <= bridgeSize && bridgeSize <= MAXIMUM_BRIDGE_SIZE;
    }

    private boolean checkMovingValue(String moving) {
        return moving.equals(MOVING_UP) || moving.equals(MOVING_DOWN);
    }

    private boolean checkGameCommandValue(String gameCommand) {
        return gameCommand.equals(GAME_RESTART) || gameCommand.equals(GAME_QUIT);
    }



}
