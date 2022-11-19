package bridge.model;

import java.util.Stack;

public class Player {

    private Stack<BridgeBlock> history;

    public Player() {
        history = new Stack<>();
    }

    public BridgeBlock move(Direction direction) {
        history.add(new BridgeBlock(direction, getPosition()));
        return currentBridgeBlock();
    }

    public int getPosition() {
        return history.size();
    }

    public BridgeBlock currentBridgeBlock() {
        return history.peek();
    }
}
