package bridge;

import java.util.Arrays;

public enum MovingStatus {
    UP("U", 1),
    DOWN("D", 0);

    private final String movingCommand;
    private final int movingNumber;

    MovingStatus(String movingCommand, int movingNumber) {
        this.movingCommand = movingCommand;
        this.movingNumber = movingNumber;
    }

    public static MovingStatus findByMoving(int moving) {
        return Arrays.stream(values())
                .filter(value -> value.movingNumber == moving)
                .findAny()
                .orElse(null);
    }

    public static MovingStatus findByCommand(String movingCommand) {
        return Arrays.stream(values())
                .filter(value -> value.movingCommand.equals(movingCommand))
                .findAny()
                .orElse(null);
    }

    String getMovingCommand() {
        return this.movingCommand;
    }

    public int getMovingNumber() {
        return this.movingNumber;
    }
}
