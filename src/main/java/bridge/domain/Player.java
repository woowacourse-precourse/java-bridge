package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final List<String> inputs;

    public Player() {
        this.inputs = new ArrayList<>();
    }

    public void inputDirection(String direction) {
        inputs.add(direction);
    }

    public List<String> getInputs() {
        return Collections.unmodifiableList(inputs);
    }
}
