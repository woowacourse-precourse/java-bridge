package bridge.model;

import java.util.Stack;

public class Player {

    private Stack<BridgeBlock> history;

    public Player() {
        history = new Stack<>();
    }
}
