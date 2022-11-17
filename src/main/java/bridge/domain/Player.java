package bridge.domain;

public class Player {

    private int position;  // TODO 객체화 고민
    private int totalNumberOfChallenges;

    public Player(int position, int totalNumberOfChallenges) {
        this.position = position;
        this.totalNumberOfChallenges = totalNumberOfChallenges;
    }

    public void move() {
        position++;  // TODO 가변? 불변?
    }

    public void initPosition() {
        position = 0;
    }

    public void increaseNumberOfChallenges() {
        totalNumberOfChallenges++;
    }

    public int position() {
        return position;
    }

    int totalNumberOfChallenges() {
        return totalNumberOfChallenges;
    }

    public boolean positionNotMoreThan(int bridgeSize) {
        return position < bridgeSize;
    }
}
