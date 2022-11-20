package bridge.model;

import bridge.view.InputView;

public class Player {
    private InputView moving;
    public Player() {
        moving = new InputView();
    }

    public String move() {
        return moving.readMoving();
    }


}
