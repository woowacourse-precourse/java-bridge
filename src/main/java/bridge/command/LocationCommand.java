package bridge.command;

public enum LocationCommand {
    Up("U", 1),
    Down("D", 0);

    private final String direction;
    private final int randomNumber;

    LocationCommand(String direction, int randomNumber) {
        this.direction = direction;
        this.randomNumber = randomNumber;
    }

    public String getDirection() {
        return direction;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
