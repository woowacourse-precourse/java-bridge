package bridge.domain;

import java.util.List;
import java.util.StringJoiner;

public class BridgePrintMaker {
    StringJoiner upStringJoiner;
    StringJoiner downStringJoiner;

    public BridgePrintMaker() {
        this.upStringJoiner = new StringJoiner(" | ", "[ ", " ]");
        this.downStringJoiner = new StringJoiner(" | ", "[ ", " ]");
    }

    public void addStepBridge(String userSelectMove, Direction stepDirection) {
        upStringJoiner.add(Move.getFilterBridgeMove(userSelectMove, Direction.UP, stepDirection));
        downStringJoiner.add(Move.getFilterBridgeMove(userSelectMove, Direction.DOWN, stepDirection));
    }

    public String getBridgePrint() {
        return upStringJoiner.toString() + "\n" + downStringJoiner.toString();
    }
}
