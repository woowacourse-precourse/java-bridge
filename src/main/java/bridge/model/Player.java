package bridge.model;

import bridge.view.InputView;

public class Player {
    private int currentIndex;
    private int tries;
    public Player() {
        this.currentIndex = -1;
        this.tries = 0;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
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
