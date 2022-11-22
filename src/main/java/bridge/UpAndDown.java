package bridge;

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

    public static UpAndDown findUpAndDown(int randomValue) {
        return Arrays.stream(UpAndDown.values())
                .filter(c -> c.getRandomValue() == randomValue)
                .findFirst().get();
    }
    
    public int getRandomValue() {
        return randomValue;
    }
}
