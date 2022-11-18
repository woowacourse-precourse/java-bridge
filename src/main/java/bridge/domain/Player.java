package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private List<String> bridge;
    private int position;

    public Player() {
        this.bridge = new ArrayList<>();
        this.position = 0;
    }

    public List<String> get() {
        return bridge;
    }

    public void addMove(String playerMove) {
        bridge.add(playerMove);
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }
}
