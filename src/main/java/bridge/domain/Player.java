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

    public int getLastIndex() {
        return inputs.size() - 1;
    }

    public String getLastInput() {
        return inputs.get(inputs.size() - 1);
    }

    public List<String> getInputs() {
        return Collections.unmodifiableList(inputs);
    }
}
