package bridge.model;

import bridge.view.InputView;

public class Player {
    private int currentLocation;
    private int tries;
    public Player() {
        this.currentLocation = -1;
        this.tries = 0;
    }
    public int inputBridgeSize() {
        return InputView.readBridgeSize();
    }

    public void tryGame() {
        this.tries++;
    }

    public String inputMove() {
        return InputView.readMoving();
    }
}
