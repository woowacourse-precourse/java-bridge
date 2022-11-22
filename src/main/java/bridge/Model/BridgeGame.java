package bridge.Model;

import bridge.View.UiMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BridgeGame {

    public List<String> bridge;
    public Stack<String> user;
    public String upperResult = UiMessage.EMPTY_GRAPH.getValue();
    public String lowerResult = UiMessage.EMPTY_GRAPH.getValue();

    public int idx;

    public int size;
    public int runCount = 1;

    private BridgeGame() {
        this.user = new Stack<>();
        this.bridge = new ArrayList<>();
    }

    public void move(String input) {
        user.add(input);
    }

    public void retry() {
        user = new Stack<>();
        upperResult = UiMessage.EMPTY_GRAPH.getValue();
        lowerResult = UiMessage.EMPTY_GRAPH.getValue();
        runCount++;
    }

    public static BridgeGame getBridgeGame() {
        return new BridgeGame();
    }
}
