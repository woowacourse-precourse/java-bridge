package bridge.domain;

import java.util.Iterator;
import java.util.List;

public class Bridge implements Iterable<BridgeMove> {

    private BridgeLength bridgeLength;
    private List<BridgeMove> moves;

    public Bridge(BridgeLength bridgeLength, List<BridgeMove> moves) {
        this.bridgeLength = bridgeLength;
        this.moves = moves;
    }

    ;

    public BridgeLength getBridgeLength() {
        return bridgeLength;
    }


    @Override
    public Iterator<BridgeMove> iterator() {
        return moves.iterator();
    }

    public BridgeMove getMove(int round) {
        BridgeMove move = null;
        try {
            move = moves.get(round - 1);
        } catch (IndexOutOfBoundsException exception) {
            throw new IndexOutOfBoundsException("round는 1이상 다리 길이 이하의 값이어야 합니다.");
        }
        return move;
    }

}
