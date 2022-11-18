package bridge;

public enum BridgeComponent {
    UP(1, "U"),
    DOWN(0, "D");

    private final int randomNumber;
    private final String mark;

    BridgeComponent(int randomNumber, String mark) {
        this.randomNumber = randomNumber;
        this.mark = mark;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public String getMark() {
        return mark;
    }
}
