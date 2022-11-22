package bridge.domain;

import bridge.constants.Command;
import bridge.constants.Move;

import java.util.List;
import java.util.Objects;

public class BridgeGame {

    private boolean canMove;
    private boolean doRetry;

    public void move(String move, int idx, List<String> bridge) {

        canMove = checkOneStep(move, bridge, idx);
    }

    private boolean checkOneStep(String move, List<String> bridge, int idx) {
        if (Objects.equals(move, Move.UP_BRIDGE.getValue())) {
            return check(bridge, idx);
        }
        return !(check(bridge, idx));
    }

    private boolean check(List<String> bridge, int idx) {
        return Objects.equals(bridge.get(idx), Move.UP_BRIDGE.getValue());
    }

    public void retry(String retryOrQuit) {
        doRetry = Objects.equals(retryOrQuit, Command.RETRY.getCommandGame());
    }

    public void initialize() {
        canMove = true;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public boolean getDoRetry() {
        return doRetry;
    }
}
