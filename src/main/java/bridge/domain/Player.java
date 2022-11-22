package bridge.domain;

public class Player {

    private Position position;
    private ChallengeNumbers challengeNumbers;

    public Player(Position position, ChallengeNumbers challengeNumbers) {
        this.position = position;
        this.challengeNumbers = challengeNumbers;
    }

    public boolean isOnTheBridge(final Bridge bridge) {
        return bridge.isLongerThan(position);
    }

    public void resetPosition() {
        position = position.reset();
    }

    public void move() {
        position = position.increase();
    }

    public void increaseChallenges() {
        challengeNumbers = challengeNumbers.increase();
    }

    public int position() {
        return position.value();
    }

    public int challengeNumbers() {
        return challengeNumbers.value();
    }
}
