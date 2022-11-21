package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class BridgeGame {
    private final Bridge bridge;
    private final Stack<Direction> movement;
    private final MapMaker mapMaker;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        bridge = makeBridge(size, bridgeNumberGenerator);
        movement = new Stack<>();
        mapMaker = new MapMaker();
    }

    private Bridge makeBridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<Direction> newBridge = new ArrayList<>();
        for (String direction : bridgeMaker.makeBridge(size)) {
            newBridge.add(Direction.valueOf(direction));
        }
        return new Bridge(newBridge);
    }

    public String move(Direction direction) {
        movement.push(direction);
        String map = mapMaker.buildMap(movement, bridge);
        return map;
    }

    public void retry() throws EmptyStackException {
        movement.pop();
    }

    public boolean failToMove() {
        return !bridge.canMove(movement);
    }

    public boolean isEndOfBridge() {
        return bridge.arriveAtTheEnd(movement);
    }
}
