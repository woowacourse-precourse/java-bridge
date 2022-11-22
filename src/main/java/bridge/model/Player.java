package bridge.model;

import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int currentIndex;
    private int tries;
    private List<String> way;

    public Player() {
        this.currentIndex = -1;
        this.tries = 1;
        this.way = new ArrayList<>();
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getTries() {
        return this.tries;
    }

    public List<String> getWay() {
        return this.way;
    }

    public int inputBridgeSize() {
        return InputView.readBridgeSize();
    }

    public void retry() {
        this.currentIndex = -1;
        this.tries++;
        this.way.clear();
    }

    public String inputMove() {
        return InputView.readMoving();
    }

    public void addWay(String location) {
        way.add(location);
    }

    public void move() {
        this.currentIndex++;
    }

    public String inputCommand() {
        return InputView.readGameCommand();
    }

}
