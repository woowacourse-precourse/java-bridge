package bridge.domain;


import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private List<String> inputs;
    private final Result result;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.inputs = new ArrayList<>();
        this.result = new Result();
    }

    public boolean move(String direction) {
        if(hasNotSameDirection()) {
            retry();
        }
        if(isFinish()) {
            throw new IndexOutOfBoundsException();
        }
        inputDirection(direction);
        return true;
    }

    public void retry() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    public void inputDirection(String direction) {
        inputs.add(direction);
    }

    public void initialize() {
        inputs = new ArrayList<>();
    }

    public boolean isFinish() {
        return bridge.isFinish(inputs.size());
    }

    public boolean hasNotSameDirection() {
        int lastIdx = inputs.size() - 1;
        return !inputs.get(lastIdx).equals(bridge.canMoveDirection(lastIdx));
    }
}
