package bridge.domain;

import java.util.Iterator;
import java.util.List;

public class Bridge implements Iterable<BridgeMove> {

    private BridgeSize bridgeSize;
    private List<BridgeMove> moves;

    public Bridge(BridgeSize bridgeSize, List<BridgeMove> moves) {
        this.bridgeSize = bridgeSize;
        this.moves = moves;
    }

    ;

    public int size() {
        return bridgeSize.getSize();
    }

    @Override
    public Iterator<BridgeMove> iterator() {
        return moves.iterator();
    }

    public BridgeMove getMove(int order) {
        BridgeMove move = null;
        try {
            move = moves.get(order);
        } catch (IndexOutOfBoundsException exception) {
            throw new IndexOutOfBoundsException("order는 1이상 다리 길이 이하의 값이어야 합니다.");
        }
        return move;
    }

}
