package bridge;

public enum MovingRandomNumber {
    UP("U", 1),
    DOWN("D", 0);

    private String moving;
    private int randomNumber;
    private String choice;

    MovingRandomNumber(String moving, int randomNumber) {
        this.moving = moving;
        this.randomNumber = randomNumber;
    }

    public String getMoving() {
        return moving;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
