package bridge.domain;

public class Player {
    private int position;
    private int totalTryNumber;

    public Player() {
        this.position = 0;
    }

    public void move() {
        this.position += 1;
    }

    public void tryGame() {
        this.totalTryNumber += 1;
    }

    public int nowPosition() {
        return this.position;
    }

    public int getTotalTryNumber() {
        return this.totalTryNumber;
    }
}
