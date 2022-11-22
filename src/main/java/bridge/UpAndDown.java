package bridge;

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
}
