package bridge.model;

public class Player {
    private int position;

    public Player() {
        initPosition();
    }

    public void initPosition() {
        this.position = -1;
    }

    public int nextStep() {
        this.position = this.position + 1;
        return this.position;
    }
}
