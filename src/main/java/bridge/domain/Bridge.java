package bridge.domain;

import java.util.Iterator;
import java.util.List;

public class Bridge implements Iterable<BridgeMove> {

    private final BridgeLength bridgeLength;
    private final List<BridgeMove> passable;

    public Bridge(BridgeLength bridgeLength, List<BridgeMove> passable) {
        this.bridgeLength = bridgeLength;
        this.passable = passable;
    }

    public BridgeLength getBridgeLength() {
        return bridgeLength;
    }


    @Override
    public Iterator<BridgeMove> iterator() {
        return passable.iterator();
    }

    public BridgeMove getMove(int round) {
        BridgeMove move = null;
        try {
            move = passable.get(round - 1);
        } catch (IndexOutOfBoundsException exception) {
            throw new IndexOutOfBoundsException("round는 1이상 다리 길이 이하의 값이어야 합니다.");
        }
        return move;
    }

}
