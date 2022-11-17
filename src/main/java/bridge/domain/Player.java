package bridge.domain;

public class Player {

    private int tryCount;
    private int positionIndex;

    public Player() {
        this.tryCount = 0;
        initPosition();
    }


    private void initPosition() {
        this.positionIndex = 0;
    }
}
