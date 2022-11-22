package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeMoveState {

    private final List<Boolean> state = new ArrayList<>();

    public void update(boolean canMove) {
        state.add(canMove);
    }

    public int getMoveCount() {
        return state.size();
    }

    public boolean getLastState() {
        return state.get(getMoveCount() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeMoveState moveState = (BridgeMoveState) o;
        return Objects.equals(state, moveState.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    public List<Boolean> getState() {
        return state;
    }
}
