package bridge.repository;

import java.util.ArrayList;
import java.util.List;

public class BridgeMoveRepository {

    private static final List<String> upperBridgeMove = new ArrayList<>();
    private static final List<String> lowerBridgeMove = new ArrayList<>();

    public void add(String upperMove, String lowerMove) {
        upperBridgeMove.add(upperMove);
        lowerBridgeMove.add(lowerMove);
    }

    public List<String>[] findAll() {
        List<String>[] bridgeMove = new ArrayList[2];
        bridgeMove[0] = upperBridgeMove;
        bridgeMove[1] = lowerBridgeMove;
        return bridgeMove;
    }

    public void clear() {
        upperBridgeMove.clear();
        lowerBridgeMove.clear();
    }
}
