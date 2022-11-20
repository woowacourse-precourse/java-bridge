package bridge.command;

import static bridge.util.Constant.*;

public enum LocationCommand {
    Up("U", 1),
    Down("D", 0);

    private final String direction;
    private final int randomNumber;

    LocationCommand(String direction, int randomNumber) {
        this.direction = direction;
        this.randomNumber = randomNumber;
    }

    // 건널 수 있는 위치를 나타내는 기능
    public static String decideLocationToCross(int randomNumber) {
        if (randomNumber == Up.getRandomNumber()) {
            return Up.getDirection();
        } else if (randomNumber == Down.getRandomNumber()) {
            return Down.getDirection();
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_MAKE_INPUT_ERROR);
    }

    public String getDirection() {
        return direction;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
