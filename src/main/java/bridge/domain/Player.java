package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player  {
    private List<String> inputs;

    private final int bridgeLength;
    private int temp;

    public Player(int length) {
        this.inputs = new ArrayList<>();
        this.temp = 0;
        this.bridgeLength = length;
    }

    public void inputDirection(String direction) {
        inputs.add(direction);
    }
    public void initialize() {
        inputs = new ArrayList<>();
    }

    public void tryGame() {
        this.temp++;
    }

    public int getTryGameCount() {
        return temp;
    }

    public boolean isFinish() {
        return inputs.size() == bridgeLength;
    }

    public boolean hasNotSameDirection(Bridge bridge) {
        int lastIdx = inputs.size() - 1;
        return !inputs.get(lastIdx).equals(bridge.canMoveDirection(lastIdx));
    }
}
