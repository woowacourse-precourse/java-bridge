package bridge.command;

import static bridge.util.Constant.*;

public enum LocationCommand {
    Up("U", 1),
    Down("D", 0);

    private final String direction;
    private final int locationNumber;

    LocationCommand(String direction, int locationNumber) {
        this.direction = direction;
        this.locationNumber = locationNumber;
    }

    // 건널 수 있는 위치를 나타내는 기능
    public static String decideLocationToCross(int randomNumber) {
        if (randomNumber == Up.getLocationNumber()) {
            return Up.getDirection();
        } else if (randomNumber == Down.getLocationNumber()) {
            return Down.getDirection();
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_MAKE_INPUT_ERROR);
    }

    public static boolean isUpDirection(String userInput) {
        return Up.direction.equals(userInput);
    }

    public static boolean isDownDirection(String userInput) {
        return Down.direction.equals(userInput);
    }

    public String getDirection() {
        return direction;
    }

    public int getLocationNumber() {
        return locationNumber;
    }
}
