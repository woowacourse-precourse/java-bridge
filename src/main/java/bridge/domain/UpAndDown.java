package bridge.domain;

import java.util.Arrays;

public enum UpAndDown {
    UP("U",1,"위"), DOWN("D",0, "아래");

    private String command;
    private int randomValue;
    private String description;

    UpAndDown(String command, int randomValue, String description) {
        this.command = command;
        this.randomValue = randomValue;
        this.description = description;
    }

    public static String convertRandomValueToCommand(int randomValue) {
        return findUpAndDown(randomValue).getCommand();
    }

    public static UpAndDown findUpAndDown(int randomValue) {
        return Arrays.stream(UpAndDown.values())
                .filter(c -> c.getRandomValue() == randomValue)
                .findFirst().get();
    }

    public static boolean isUpOrDown(String moving) {
        return Arrays.stream(UpAndDown.values())
                .anyMatch(c -> c.getCommand().equals(moving));
    }

    public String getCommand() {
        return command;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
