package bridge.domain;

import java.util.Iterator;
import java.util.List;

public class Bridge implements Iterable<BridgeMove> {

    private final int size;
    private final List<BridgeMove> passable;

    public Bridge(int size, List<BridgeMove> passable) {
        if (size != passable.size()) {
            throw new IllegalArgumentException("잘못된 다리 정보 입니다.");
        }
        this.size = size;
        this.passable = passable;
    }

    public int size() {
        return size;
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
