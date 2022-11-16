package bridge;

public enum UpAndDown {
    UP("U", 1),
    DOWN("D", 0);

    private String direction;
    private int InputDirectionNumber;

    UpAndDown(String direction, int inputDirectionNumber) {
        this.direction = direction;
        this.InputDirectionNumber = inputDirectionNumber;
    }
}
